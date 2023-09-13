package neivcs.api.controller;

import jakarta.validation.Valid;
import neivcs.api.domain.catcha.CatchValidation;
import neivcs.api.domain.catcha.dto.CatchData;
import neivcs.api.domain.catcha.dto.CatchDataDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/captura")

public class CatchController {

    @Autowired
    private CatchValidation catchValidation;

    @PostMapping
    @Transactional
    public ResponseEntity post(@RequestBody @Valid CatchData data) {
        catchValidation.catching(data);
        return ResponseEntity.ok(new CatchDataDetails( null, null, null, null));
    }
}
