package user.ishmaust.shophelper.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

@Data
public class ProductDto {

  @NotBlank()
  private String name;
  private String description;
  @Positive()
  private int orderPrice;
  @Range(min = 0, max = 500)
  private int margin;
  private Long container;
  @NotBlank
  private String company;
  @PositiveOrZero
  private int count;
  @PositiveOrZero
  private int minCount;

}
