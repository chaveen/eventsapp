package org.devchavez.events.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Search criteria
 */
@ApiModel(description = "Search criteria")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-07-08T10:46:52.859-04:00[America/New_York]")

public class SearchCriteria   {
  @JsonProperty("createdAt")
  private OffsetDateTime createdAt;

  @JsonProperty("email")
  private String email;

  @JsonProperty("environment")
  private String environment;

  @JsonProperty("component")
  private String component;

  @JsonProperty("message")
  private String message;

  public SearchCriteria createdAt(OffsetDateTime createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  /**
   * Creation Timestamp
   * @return createdAt
  */
  @ApiModelProperty(value = "Creation Timestamp")

  @Valid

  public OffsetDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(OffsetDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public SearchCriteria email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Email address
   * @return email
  */
  @ApiModelProperty(value = "Email address")


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public SearchCriteria environment(String environment) {
    this.environment = environment;
    return this;
  }

  /**
   * Environment name
   * @return environment
  */
  @ApiModelProperty(value = "Environment name")


  public String getEnvironment() {
    return environment;
  }

  public void setEnvironment(String environment) {
    this.environment = environment;
  }

  public SearchCriteria component(String component) {
    this.component = component;
    return this;
  }

  /**
   * Component name
   * @return component
  */
  @ApiModelProperty(value = "Component name")


  public String getComponent() {
    return component;
  }

  public void setComponent(String component) {
    this.component = component;
  }

  public SearchCriteria message(String message) {
    this.message = message;
    return this;
  }

  /**
   * Partial message
   * @return message
  */
  @ApiModelProperty(value = "Partial message")


  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SearchCriteria searchCriteria = (SearchCriteria) o;
    return Objects.equals(this.createdAt, searchCriteria.createdAt) &&
        Objects.equals(this.email, searchCriteria.email) &&
        Objects.equals(this.environment, searchCriteria.environment) &&
        Objects.equals(this.component, searchCriteria.component) &&
        Objects.equals(this.message, searchCriteria.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(createdAt, email, environment, component, message);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SearchCriteria {\n");
    
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    environment: ").append(toIndentedString(environment)).append("\n");
    sb.append("    component: ").append(toIndentedString(component)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
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

