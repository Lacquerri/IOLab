package vod.web.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import vod.model.Producer;
import vod.model.Supplement;
import vod.service.SupplementService;
import vod.web.rest.dto.SupplementDTO;

@Component
@RequiredArgsConstructor
public class SupplementValidator implements Validator {
    private final SupplementService supplementService;

    @Override
    public boolean supports(Class<?> clazz) {return clazz.equals(SupplementDTO.class);}

    @Override
    public void validate(Object target, Errors errors) {
        SupplementDTO supplement = (SupplementDTO) target;
        Producer producer = supplementService.getProducerById(supplement.getProducerId());
        if(producer == null) {
            errors.rejectValue("producerId", null, "supplement.producer.missing");
        }
    }

}
