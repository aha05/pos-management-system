package com.pos.merchant.merchant;

import com.pos.merchant.common.ErrorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "CRUD REST APIs for Merchant in POS",
        description = "CRUD REST APIs in POS to CREATE, UPDATE, FETCH AND DELETE Merchant details"
)
@RestController
@RequestMapping(path = "/merchant", produces = {MediaType.APPLICATION_JSON_VALUE})
@RequiredArgsConstructor
public class MerchantController {
    private final MerchantService merchantService;

    @Operation(
            summary = "Fetch merchants REST API",
            description = "REST API to fetch merchants details inside POSMS"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponse.class)
                    )
            )
    }
    )
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<MerchantResponse> getMerchants() {
        return merchantService.getMerchants();
    }

    @Operation(
            summary = "Fetch Merchant By Id REST API",
            description = "REST API to to fetch merchant details by ID inside POSMS"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponse.class)
                    )
            )
    }
    )
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MerchantResponse getMerchantById(@PathVariable(name = "id") Long merchantId) {
        return merchantService.getMerchantById(merchantId);
    }


    @Operation(
            summary = "Fetch Merchant Information REST API",
            description = "REST API to fetch merchant information inside POSMS"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status CREATED"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponse.class)
                    )
            )
    }
    )
    @GetMapping("/info")
    @ResponseStatus(HttpStatus.OK)
    public List<MerchantInformation> getMerchantInfo() {
        return merchantService.getMerchantInfo();
    }


    @Operation(
            summary = "Fetch Merchant Information By Id REST API",
            description = "REST API to fetch merchant information By Id inside POSMS"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status CREATED"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponse.class)
                    )
            )
    }
    )
    @GetMapping("/info/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MerchantInformation getMerchantInfoById(@PathVariable(name = "id") Long merchantId) {
        return merchantService.getMerchantInfoById(merchantId);
    }

    @Operation(
            summary = "Create new merchant REST API",
            description = "REST API to create new Merchant inside POSMS"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "HTTP Status CREATED"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponse.class)
                    )
            )
    }
    )
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public MerchantResponse addMerchant(@Valid @RequestBody MerchantRequest request) {
        return merchantService.addMerchant(request);
    }
}
