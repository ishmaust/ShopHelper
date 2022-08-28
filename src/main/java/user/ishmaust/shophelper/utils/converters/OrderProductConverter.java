package user.ishmaust.shophelper.utils.converters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Set;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import user.ishmaust.shophelper.dto.OrderProduct;

@Converter
@Component
public class OrderProductConverter implements AttributeConverter<Set<OrderProduct>, String> {

  private final ObjectMapper objectMapper;
  private final JavaType type;

  @Autowired
  public OrderProductConverter(ObjectMapper objectMapper) {
    this.objectMapper = objectMapper;
    this.type = objectMapper.getTypeFactory().constructCollectionType(Set.class, OrderProduct.class);
  }

  @Override
  public String convertToDatabaseColumn(Set<OrderProduct> attribute) {
    if(attribute == null) {
      return null;
    }

    try {
      return objectMapper.writeValueAsString(attribute);
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public Set<OrderProduct> convertToEntityAttribute(String dbData) {
    if(dbData == null || dbData.isEmpty()) {
      return null;
    }

    try {
      return objectMapper.readValue(dbData, type);
    } catch (JsonProcessingException e) {
      throw new RuntimeException();
    }
  }
}
