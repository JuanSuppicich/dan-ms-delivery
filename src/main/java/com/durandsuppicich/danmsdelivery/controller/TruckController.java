package com.durandsuppicich.danmsdelivery.controller;

import com.durandsuppicich.danmsdelivery.domain.Truck;
import com.durandsuppicich.danmsdelivery.dto.TruckRequestDto;
import com.durandsuppicich.danmsdelivery.dto.TruckResponseDto;
import com.durandsuppicich.danmsdelivery.mapper.ITruckMapper;
import com.durandsuppicich.danmsdelivery.service.ITruckService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/trucks")
@Api(value = "TruckController")
public class TruckController {

    private final ITruckService truckService;

    private final ITruckMapper truckMapper;

    public TruckController(ITruckService truckService,
                           ITruckMapper truckMapper) {
        this.truckService = truckService;
        this.truckMapper = truckMapper;
    }

    @PostMapping
    @ApiOperation(value = "Creates a new truck")
    public ResponseEntity<TruckResponseDto> post(@RequestBody TruckRequestDto truckDto) {

        Truck truck = truckMapper.map(truckDto);
        Truck result = truckService.post(truck);
        TruckResponseDto body = truckMapper.mapToDto(result);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(body.getId())
                .toUri();

        return ResponseEntity.created(location).body(body);
    }

    @GetMapping
    @ApiOperation(value = "Retrieves all trucks")
    public ResponseEntity<List<TruckResponseDto>> getAll() {

        List<Truck> trucks = truckService.getAll();
        List<TruckResponseDto> body = truckMapper.mapToDto(trucks);

        return ResponseEntity.ok(body);
    }

    @GetMapping(path = "/availables")
    @ApiOperation(value = "Retrieves all available trucks")
    public ResponseEntity<List<TruckResponseDto>> getAvailable() {

        List<Truck> trucks = truckService.getAvailable();
        List<TruckResponseDto> body = truckMapper.mapToDto(trucks);

        return ResponseEntity.ok(body);
    }

    @DeleteMapping(path = "/{id}")
    @ApiOperation(value = "Delete a truck base on the given id")
    public ResponseEntity<?> delete(@PathVariable Integer id) {

        truckService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

