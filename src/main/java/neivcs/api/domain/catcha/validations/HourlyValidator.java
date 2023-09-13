package neivcs.api.domain.catcha.validations;

import jakarta.validation.ValidationException;
import neivcs.api.domain.catcha.dto.CatchData;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;

@Component
public class HourlyValidator implements CatchValidator {

    public void validate(CatchData data){
        var catchDate = data.catchDate();

        var sunday = catchDate.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var beforeHour = catchDate.getHour() < 9;
        var afterHour = catchDate.getHour() > 22;
        if(sunday || beforeHour || afterHour) {
            throw new ValidationException("Esta hora o pokémon esta off.");
        }
    }
}
