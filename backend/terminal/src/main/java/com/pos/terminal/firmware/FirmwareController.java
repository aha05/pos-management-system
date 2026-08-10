package com.pos.terminal.firmware;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("terminal/firmware")
@RequiredArgsConstructor
public class FirmwareController {
    private final FirmwareService firmwareService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<FirmwareResponse> getFirmwares() {
        return firmwareService.getFirmwares();
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public FirmwareResponse addFirmware(@Valid @RequestBody FirmwareRequest request) {
        return firmwareService.addFirmware(request);
    }
}
