package pl.handbook.services.model;


import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
@Component
public class Wood {

  private Integer diametr;
  private Integer width;
  private Integer length;
  private List<String> type;
  private Map<String, Double> dryFactor;
  private Map<String, Double> wetFactor;

  public Wood() {
  }

  public Integer getDiametr() {
    return diametr;
  }

  public void setDiametr(Integer diametr) {
    this.diametr = diametr;
  }

  public Integer getWidth() {
    return width;
  }

  public void setWidth(Integer width) {
    this.width = width;
  }

  public Integer getLength() {
    return length;
  }

  public List<String> getType() {
    return type;
  }

  public void setType(List<String> type) {
    this.type = type;
  }

  public Map<String, Double> getDryFactor() {
    return dryFactor;
  }

  public void setDryFactor(Map<String, Double> dryFactor) {
    this.dryFactor = dryFactor;
  }

  public Map<String, Double> getWetFactor() {
    return wetFactor;
  }

  public void setWetFactor(Map<String, Double> wetFactor) {
    this.wetFactor = wetFactor;
  }

  public void setLength(Integer length) {
    this.length = length;
  }
}
