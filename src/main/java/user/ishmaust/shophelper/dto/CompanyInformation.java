package user.ishmaust.shophelper.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class CompanyInformation {

  @NotNull
  private String city;

  @Pattern(regexp = "(\\+375)[0-9]{9}")
  private String phone;

  private String address;

}
