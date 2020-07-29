/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf;

import java.util.Map;

/**
 *
 * @author Gus
 */
 public class DonutModel {
    String Title;
    String LegendPosition;
    int SliceMargin;
    Boolean ShowDataLabels;
    String DataFormat;
    Boolean Shadow;
    Map<String, Number> circulo;

    public Map<String, Number> getCirculo() {
        return circulo;
    }

    public void setCirculo(Map<String, Number> circulo) {
        this.circulo = circulo;
    }
    

        public String getTitle() {
            return Title;
        }

        public void setTitle(String Title) {
            this.Title = Title;
        }

        public String getLegendPosition() {
            return LegendPosition;
        }

        public void setLegendPosition(String LegendPosition) {
            this.LegendPosition = LegendPosition;
        }

        public int getSliceMargin() {
            return SliceMargin;
        }

        public void setSliceMargin(int SliceMargin) {
            this.SliceMargin = SliceMargin;
        }

        public Boolean getShowDataLabels() {
            return ShowDataLabels;
        }

        public void setShowDataLabels(Boolean ShowDataLabels) {
            this.ShowDataLabels = ShowDataLabels;
        }

        public String getDataFormat() {
            return DataFormat;
        }

        public void setDataFormat(String DataFormat) {
            this.DataFormat = DataFormat;
        }

        public Boolean getShadow() {
            return Shadow;
        }

        public void setShadow(Boolean Shadow) {
            this.Shadow = Shadow;
        }
        
 
        }