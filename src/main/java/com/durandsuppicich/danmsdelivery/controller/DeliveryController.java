package com.durandsuppicich.danmsdelivery.controller;

import com.durandsuppicich.danmsdelivery.domain.Delivery;
import com.durandsuppicich.danmsdelivery.dto.DeliveryRequestDto;
import com.durandsuppicich.danmsdelivery.dto.DeliveryResponseDto;
import com.durandsuppicich.danmsdelivery.mapper.IDeliveryMapper;
import com.durandsuppicich.danmsdelivery.service.IDeliveryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Mod11Check;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.net.URI;
import java.util.List;

@RestController
@Validated
@RequestMapping(value = "/api/deliveries")
@Api(value = "DeliveryController")
@CrossOrigin(origins = "*", methods=
        {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.PATCH, RequestMethod.DELETE})
public class DeliveryController {

    private final IDeliveryService deliveryService;

    private final IDeliveryMapper deliveryMapper;

    public DeliveryController(IDeliveryService deliveryService,
                              IDeliveryMapper deliveryMapper) {
        this.deliveryService = deliveryService;
        this.deliveryMapper = deliveryMapper;
    }

    @PostMapping
    @ApiOperation(value = "Creates a new delivery")
    public ResponseEntity<DeliveryResponseDto> post(@Valid @RequestBody DeliveryRequestDto deliveryDto) {

        Delivery delivery = deliveryMapper.map(deliveryDto);
        Delivery result = deliveryService.post(delivery);
        DeliveryResponseDto body = deliveryMapper.mapToDto(result);

        body.setEmployeeName(deliveryService.getEmployeeName());

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(body.getId())
                .toUri();

        return ResponseEntity.created(location).body(body);
    }

    @GetMapping
    @ApiOperation(value = "Retrieves all deliveries")
    public ResponseEntity<List<DeliveryResponseDto>> getAll() {

        List<Delivery> deliveries = deliveryService.getAll();
        List<DeliveryResponseDto> body = deliveryMapper.mapToDto(deliveries);

        return ResponseEntity.ok(body);
    }

    @GetMapping(params = "cuit")
    @ApiOperation(value = "Retrieves all deliveries based on the given customer cuit")
    public ResponseEntity<List<DeliveryResponseDto>> getByCustomerCuit(@RequestParam(name = "cuit")
                                                                           @NotBlank
                                                                           @Length(min = 11, max = 11)
                                                                           @Mod11Check(threshold = 7) String cuit) {

        List<Delivery> deliveries = deliveryService.getByCustomerCuit(cuit);
        List<DeliveryResponseDto> body = deliveryMapper.mapToDto(deliveries);

        return ResponseEntity.ok(body);
    }
}
