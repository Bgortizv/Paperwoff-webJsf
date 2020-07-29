package jsf;

import jpa.entidades.Users;
import jsf.util.JsfUtil;
import jsf.util.PaginationHelper;
import jpa.sessions.UsersFacade;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import static org.primefaces.component.menuitem.UIMenuItemBase.PropertyKeys.url;

@Named("usersController")
@SessionScoped
public class UsersController implements Serializable {

    private Users current;
    private Users prueba;
    private Users InicioSes;
    private DataModel items = null;
    @EJB
    private jpa.sessions.UsersFacade ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;

    public Users getInicioSes() {
        return InicioSes;
    }

    public void setInicioSes(Users InicioSes) {
        this.InicioSes = InicioSes;
    }
    
    public String validar(){
    Users us = new Users() ;
    Users uscontra = new Users();
    String url = null;
    
        try{
    System.out.println("objeto " + InicioSes);
    String documento = InicioSes.getDocumento().toString();
String pass  = InicioSes.getPassword();
    us= ejbFacade.ValidarUsuario(InicioSes);
        //System.out.println("objeto 1" + us);

        System.out.println("objeto 2" + us);
        if (us!=null) {
             uscontra= ejbFacade.ValidarContrasenia(documento,pass );
             
               if(uscontra!=null) {
               FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("NombreUsuario", InicioSes.getNombre());
               FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("UserDocumento", InicioSes.getDocumento());
               FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("UserId", InicioSes.getIdUser());
               FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("Contrasenia", InicioSes.getPassword());
               url="/faces/Dashboard.xhtml?faces-redirect=true";
                } else {
                    FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                        "La contraseña es incorrecta", "");
                FacesContext.getCurrentInstance().addMessage(null, fm);
             }      
        }else{
         FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                        "usuario no existe", "");
                FacesContext.getCurrentInstance().addMessage(null, fm);
        
        }
    } catch (Exception e){
        FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Contraseña incorrecta ", "datos incorrectos"));
       
        
    }
    
    return url;
    }
    
    private List<Users> ListaUsers;

    public List<Users> getListaUsers() {
        ListaUsers = ejbFacade.findAll();
        return ListaUsers;
    }

    public void setListaUsers(List<Users> ListaUsers) {
        this.ListaUsers = ListaUsers;
    }

    public UsersController() {
    }
    
    @PostConstruct
    public void init() {
    prueba = new Users();
    InicioSes = new Users();
    }
    public Users getSelected() {
        if (current == null) {
            current = new Users();
            selectedItemIndex = -1;
        }
        return current;
    }

    private UsersFacade getFacade() {
        return ejbFacade;
    }

    public Users getPrueba() {
    return prueba;
    }
    
    public void setPrueba(Users prueba) {
    this.prueba = prueba;
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
        current = (Users) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new Users();
        selectedItemIndex = -1;
        return "Create";
    }
    
     public String ValidaInicioSes() {
       
       
        return "Create";
    }

    public Users retornar() {
    Users retornado = new Users();
    retornado = ejbFacade.consultaN(current.getNombre());
    getUsers(retornado.getIdUser());
    
    return retornado;
    }
    
    
    public String create() {
        try {    
            System.out.println("documento" + prueba.getDocumento());
            prueba.setEstado(true);
            getFacade().create(prueba);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/resources/Bundle").getString("UsersCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/resources/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (Users) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/resources/Bundle").getString("UsersUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/resources/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (Users) getItems().getRowData();
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
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/resources/Bundle").getString("UsersDeleted"));
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

    public Users getUsers(java.lang.Long id) {
        return ejbFacade.find(id);
    }



}
