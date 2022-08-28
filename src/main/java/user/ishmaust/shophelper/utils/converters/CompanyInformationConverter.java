package user.ishmaust.shophelper.utils.converters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import user.ishmaust.shophelper.dto.CompanyInformation;

@Component
@Converter
public class CompanyInformationConverter implements AttributeConverter<CompanyInformation, String> {

  private final ObjectMapper objectMapper;

  @Autowired
  public CompanyInformationConverter(ObjectMapper objectMapper) {
    this.objectMapper = objectMapper;
  }

  @Override
  public String convertToDatabaseColumn(CompanyInformation attribute) {
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
  public CompanyInformation convertToEntityAttribute(String dbData) {
    if(dbData == null || dbData.isEmpty()) {
      return null;
    }

    try {
      return objectMapper.readValue(dbData, CompanyInformation.class);
    } catch (JsonProcessingException e) {
      throw new RuntimeException();
    }
  }
}
