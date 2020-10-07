package jsf;

import clasesEspeciales.Correo;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
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
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.servlet.http.Part;
import jpa.entidades.Users;

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
    private Part file;
    private String nombre;
    private String pathReal;
    private String mensaje;

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    @EJB
    private TutoriasFacade tutoriasFacade;
    
    private List<Tutorias> ListaTutorias;
    
   private List<Tutorias[]> ListaTutorias2;

    public List<Tutorias> getListaTutorias() {
        ListaTutorias = ejbFacade.findAll();
        return ListaTutorias;
    }

    public List<Tutorias[]> getListaTutorias2() {
        
        long  o = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("UserId").toString()) ; 
        this.ListaTutorias2 = ejbFacade.ListaTutoriasFiltro(o);
                System.out.println("Lista tutorias: "+ListaTutorias2);
        return ListaTutorias2;

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

    public Tutorias getCurrent() {
        return current;
    }

    public void setCurrent(Tutorias current) {
        this.current = current;
    }

    public TutoriasFacade getEjbFacade() {
        return ejbFacade;
    }

    public void setEjbFacade(TutoriasFacade ejbFacade) {
        this.ejbFacade = ejbFacade;
    }

    public int getSelectedItemIndex() {
        return selectedItemIndex;
    }

    public void setSelectedItemIndex(int selectedItemIndex) {
        this.selectedItemIndex = selectedItemIndex;
    }

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPathReal() {
        return pathReal;
    }

    public void setPathReal(String pathReal) {
        this.pathReal = pathReal;
    }

    public TutoriasFacade getTutoriasFacade() {
        return tutoriasFacade;
    }

    public void setTutoriasFacade(TutoriasFacade tutoriasFacade) {
        this.tutoriasFacade = tutoriasFacade;
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
    
    //Carga masiva de información
    public String upload() {
        String path = FacesContext.getCurrentInstance().getExternalContext().getRealPath("Archivos");
        path = path.substring(0, path.indexOf("\\build"));
        path = path + "\\web\\Archivos\\";
        try {
         this.nombre = file.getSubmittedFileName();
            pathReal = "/web/Archivos/" + nombre;
            path = path + this.nombre;
            InputStream in = file.getInputStream();
            
            byte[] data = new byte[in.available()];
            in.read(data);
           File archivo = new File(path);
           path = path.replace("\\","\\\\");
           System.out.println("esta es la ruta: " +path);
           
            FileOutputStream out = new FileOutputStream(archivo);
            out.write(data);            
            tutoriasFacade.cargarArchivo(path);
            in.close();
            out.close();
            archivo.delete();
            //JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/resources/Bundle").getString("Archivo Cargado"));
            setMensaje("Cargado con éxito.");    
        
        } catch (Exception e) {
            e.printStackTrace();
        }
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                    FacesMessage.SEVERITY_INFO, "Se ha realizado la operación con éxito", "Se ha cargado el archivo"));
        return "Cargado";
        
    }
    
    public void probarmetodo() {
     for(Object usu: ejbFacade.listaEstudiantesDeben()){
         System.out.println(usu);
         
     } 
    
    //envío correos masivos
    /*public void envioCorreos() throws Exception {
        List<Object> miLista =  tutoriasFacade.listaEstudiantesDeben();
        enviarCorreo(miLista);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                    FacesMessage.SEVERITY_INFO, "Se ha realizado la operación con éxito", "Se ha enviado la alerta"));
    }
 

    public void enviarCorreo(List<Object> miLista) throws Exception{
     
        
        System.out.println("tutotias"+current);
   String mensaje = "hola ";
//        String mensaje = "Estimado Cliente <br/> la tutoría  "+current.getIdTutorias()+""
//                    + " que se será tomada por el estudiante" +current.getEstudiantes().getUsers().getNombre() 
//                    +" "+current.getEstudiantes().getUsers().getApellidos()+" no ha sido cancelada"
//                        +" <br/><br/>Paperwoff <br/> Tel 3223094606";
        

       try{        
        System.out.println("lista"+miLista);
        if (!miLista.isEmpty() ) {
            System.out.println("lista"+miLista);
               Correo.send(miLista, "Tutorias: Retraso de Pago", mensaje);
        }
    
       }catch(Exception e){
       
       throw e;
       }*/

    
    }


        
    
}


   