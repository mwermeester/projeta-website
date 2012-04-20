/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projetaBeans;

import be.luckycode.projetawebservice.Project;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import pojeta.Common;
import pojeta.ProjectSimple;
import pojeta.WSProjectHelper;

/**
 *
 * @author michael
 */
@ManagedBean
@SessionScoped
public class ProjectDetailController {

    /**
     * Creates a new instance of ProjectDetailController
     */
    //@ManagedProperty("#{param.strProjectId}")
    private String strProjectId;
    
    private Integer projectId;
    
    private ProjectSimple projectSimple;
    
    private Project project;
    
    private WSProjectHelper wph;
    
    public ProjectDetailController() {
    }
    
    public String showProjectId(int id) {
        //this.projectId = Integer.parseInt(id);
        //this.projectId = Integer.parseInt(strProjectId);
        this.projectId = id;
        
        return "projectDetail.xhtml";
    }
    
    public String showProjectDetails() {
        
        //this.projectId = Integer.parseInt(getStrProjectId());
        
        this.projectId = projectSimple.getId();
        
        wph = new WSProjectHelper();
        wph.setUsernamePassword(Common.getWSUsername(), Common.getWSPassword());
        
        this.project = wph.find(Project.class, this.projectId.toString());
        
        return "projectDetail.xhtml?faces-redirect=true";
    }

    /**
     * @return the projectId
     */
    public int getProjectId() {
        return projectId;
    }

    /**
     * @return the strProjectId
     */
    public String getStrProjectId() {
        return strProjectId;
    }

    /**
     * @param strProjectId the strProjectId to set
     */
    public void setStrProjectId(String strProjectId) {
        this.strProjectId = strProjectId;
    }

    /**
     * @return the projectSimple
     */
    public ProjectSimple getProjectSimple() {
        return projectSimple;
    }

    /**
     * @param projectSimple the projectSimple to set
     */
    public void setProjectSimple(ProjectSimple projectSimple) {
        this.projectSimple = projectSimple;
    }

    /**
     * @return the project
     */
    public Project getProject() {
        return project;
    }

    /**
     * @param project the project to set
     */
    public void setProject(Project project) {
        this.project = project;
    }
    
    
}
