package fralewsmi.shortestpath.server.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import fralewsmi.shortestpath.server.model.Station;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Route
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-12-05T11:23:54.670-08:00")

public class Route   {
  @JsonProperty("stations")
  @Valid
  private List<Station> stations = null;

  public Route stations(List<Station> stations) {
    this.stations = stations;
    return this;
  }

  public Route addStationsItem(Station stationsItem) {
    if (this.stations == null) {
      this.stations = new ArrayList<Station>();
    }
    this.stations.add(stationsItem);
    return this;
  }

  /**
   * Get stations
   * @return stations
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<Station> getStations() {
    return stations;
  }

  public void setStations(List<Station> stations) {
    this.stations = stations;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Route route = (Route) o;
    return Objects.equals(this.stations, route.stations);
  }

  @Override
  public int hashCode() {
    return Objects.hash(stations);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Route {\n");
    
    sb.append("    stations: ").append(toIndentedString(stations)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

