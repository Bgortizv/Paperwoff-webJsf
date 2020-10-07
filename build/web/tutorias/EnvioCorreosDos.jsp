<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:ui="http://xmlns.jcp.org/jsf/facelets"
      xmlns:h="http://xmlns.jcp.org/jsf/html"
      xmlns:f="http://xmlns.jcp.org/jsf/core"
      xmlns:p="http://primefaces.org/ui">
    <h:head>
        <h:outputStylesheet library="css" name="EstilosMakia.css"/>
        <link href="../resources/Bottsrtap4.1/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="../resources/css/EstilosMakiaDos.css" rel="stylesheet" type="text/css"/>
    </h:head>
    <h:body class="Color">
         <ui:composition template="../Pagina Maestra/newTemplate.xhtml">
                    
        <ui:define name="content">
            <h:form styleClass="jsfcrud_list_form" enctype="multipart/form-data">
                            <table>
                <tr>
                    <td align="right">From:</td>
                    <td><h:inputText value="#{usersController.fromMail}"/> </td>
                </tr>
                <tr>
                    <td align="right">Username:</td>
                    <td><h:inputText value="#{usersController.username}"/> </td>
                </tr>
                <tr>
                    <td align="right">Password:</td>
                    <td><h:inputSecret value="#{usersController.password}"/> </td>
                </tr>
                <tr>
                    <td align="right">To:</td>
                    <td><h:inputText /> </td>
                </tr>
                <tr>
                    <td align="right">Subject:</td>
                    <td><h:inputText value="#{usersController.subject}"/> </td>
                </tr>
                <tr>
                    <td align="right">Message:</td>
                    <td><h:inputTextarea value="#{usersController.message}"/> </td>
                </tr>
            </table>
            <h:commandButton value="Send" action="#{usersController.send()}"/>
            <br/>
                
                
            </h:form>    
        </ui:define>
             
         </ui:composition>
        
        
        
    </h:body>
</html>