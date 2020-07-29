package jsf;

import jpa.entidades.Tutorias;
import jsf.util.JsfUtil;
import jsf.util.PaginationHelper;
import jpa.sessions.TutoriasFacade;

import java.io.Serializable;
import static java.util.Collections.list;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

@Named("tutoriasController")
@SessionScoped
public class TutoriasController implements Serializable {

    private Tutorias current;
    private DataModel items = null;
    @EJB
    private jpa.sessions.TutoriasFacade ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;
    private  DonutModel donutModel;
    
    private List<Tutorias> ListaTutorias;

    public List<Tutorias> getListaTutorias() {
        ListaTutorias = ejbFacade.findAll();
        return ListaTutorias;
    }

    public void setListaTutorias(List<Tutorias> ListaTutorias) {
        this.ListaTutorias = ListaTutorias;
    }
    
    
    
    

    public DonutModel getDonutModel() {
        return donutModel;
    }

    public void setDonutModel(DonutModel donutModel) {
        this.donutModel = donutModel;
    }

     @PostConstruct
    public void init() {
        
        createDonutModel();
    }

    public Tutorias getSelected() {
        if (current == null) {
            current = new Tutorias();
            selectedItemIndex = -1;
        }
        return current;
    }

    private TutoriasFacade getFacade() {
        return ejbFacade;
    }

    public PaginationHelper getPagination() {
        if (pagination == null) {
            pagination = new PaginationHelper(10) {

                @Override
                public int getItemsCount() {
                    return getFacade().count();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(getFacade().findRange(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
                }
            };
        }
        return pagination;
    }

    public String prepareList() {
        recreateModel();
        return "List";
    }

    public String prepareView() {
        current = (Tutorias) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new Tutorias();
        selectedItemIndex = -1;
        return "Create";
    }

    public String create() {
        try {
            System.out.println("usuario"+current);
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/resources/Bundle").getString("TutoriasCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/resources/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (Tutorias) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/resources/Bundle").getString("TutoriasUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/resources/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (Tutorias) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        performDestroy();
        recreatePagination();
        recreateModel();
        return "List";
    }

    public String destroyAndView() {
        performDestroy();
        recreateModel();
        updateCurrentItem();
        if (selectedItemIndex >= 0) {
            return "View";
        } else {
            // all items were removed - go back to list
            recreateModel();
            return "List";
        }
    }

    private void performDestroy() {
        try {
            getFacade().remove(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/resources/Bundle").getString("TutoriasDeleted"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/resources/Bundle").getString("PersistenceErrorOccured"));
        }
    }

    private void updateCurrentItem() {
        int count = getFacade().count();
        if (selectedItemIndex >= count) {
            // selected index cannot be bigger than number of items:
            selectedItemIndex = count - 1;
            // go to previous page if last page disappeared:
            if (pagination.getPageFirstItem() >= count) {
                pagination.previousPage();
            }
        }
        if (selectedItemIndex >= 0) {
            current = getFacade().findRange(new int[]{selectedItemIndex, selectedItemIndex + 1}).get(0);
        }
    }

    public DataModel getItems() {
        if (items == null) {
            items = getPagination().createPageDataModel();
        }
        return items;
    }

    private void recreateModel() {
        items = null;
    }
    
    public DonutModel initDonutModel (){
        DonutModel model = new DonutModel();
        Map<String, Number> circle = new LinkedHashMap<String, Number>();
        circle.put("Homescholing", 30);
        circle.put("Matemáticas", 30);
        circle.put("Español para extranjeros", 20);
        circle.put("Tutorías externas", 15);
        circle.put("otros", 5);
        System.out.println("circulo"+circle);
        
        model.setCirculo(circle);
        
        return model;
        }
    
    public void createDonutModel(){
        donutModel = initDonutModel();
        donutModel.setTitle("Custom Options");
        donutModel.setLegendPosition("e");
        donutModel.setSliceMargin(5);
        donutModel.setShowDataLabels(true);
        donutModel.setDataFormat("value");
        donutModel.setShadow(false);
    }

    private void recreatePagination() {
        pagination = null;
    }

    public String next() {
        getPagination().nextPage();
        recreateModel();
        return "List";
    }

    public String previous() {
        getPagination().previousPage();
        recreateModel();
        return "List";
    }

    public SelectItem[] getItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
    }

    public Tutorias getTutorias(java.lang.Long id) {
        return ejbFacade.find(id);
    }

 
        
    
}


   