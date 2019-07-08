package org.devchavez.events.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import java.util.UUID;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Event
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-07-08T10:46:52.859-04:00[America/New_York]")

public class Event   {
  @JsonProperty("id")
  private UUID id;

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

  @JsonProperty("data")
  private String data;

  public Event id(UUID id) {
    this.id = id;
    return this;
  }

  /**
   * Event Id
   * @return id
  */
  @ApiModelProperty(value = "Event Id")

  @Valid

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public Event createdAt(OffsetDateTime createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  /**
   * Creation Timestamp
   * @return createdAt
  */
  @ApiModelProperty(required = true, value = "Creation Timestamp")
  @NotNull

  @Valid

  public OffsetDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(OffsetDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public Event email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Email address
   * @return email
  */
  @ApiModelProperty(required = true, value = "Email address")
  @NotNull


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Event environment(String environment) {
    this.environment = environment;
    return this;
  }

  /**
   * Environment name
   * @return environment
  */
  @ApiModelProperty(required = true, value = "Environment name")
  @NotNull


  public String getEnvironment() {
    return environment;
  }

  public void setEnvironment(String environment) {
    this.environment = environment;
  }

  public Event component(String component) {
    this.component = component;
    return this;
  }

  /**
   * Component name
   * @return component
  */
  @ApiModelProperty(required = true, value = "Component name")
  @NotNull


  public String getComponent() {
    return component;
  }

  public void setComponent(String component) {
    this.component = component;
  }

  public Event message(String message) {
    this.message = message;
    return this;
  }

  /**
   * Event message
   * @return message
  */
  @ApiModelProperty(required = true, value = "Event message")
  @NotNull


  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Event data(String data) {
    this.data = data;
    return this;
  }

  /**
   * Event data
   * @return data
  */
  @ApiModelProperty(required = true, value = "Event data")
  @NotNull


  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Event event = (Event) o;
    return Objects.equals(this.id, event.id) &&
        Objects.equals(this.createdAt, event.createdAt) &&
        Objects.equals(this.email, event.email) &&
        Objects.equals(this.environment, event.environment) &&
        Objects.equals(this.component, event.component) &&
        Objects.equals(this.message, event.message) &&
        Objects.equals(this.data, event.data);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, createdAt, email, environment, component, message, data);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Event {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    environment: ").append(toIndentedString(environment)).append("\n");
    sb.append("    component: ").append(toIndentedString(component)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
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

