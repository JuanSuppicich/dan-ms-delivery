package com.durandsuppicich.danmsdelivery.controller;

import com.durandsuppicich.danmsdelivery.domain.Package;
import com.durandsuppicich.danmsdelivery.dto.PackageRequestDto;
import com.durandsuppicich.danmsdelivery.dto.PackageResponseDto;
import com.durandsuppicich.danmsdelivery.mapper.IPackageMapper;
import com.durandsuppicich.danmsdelivery.service.IPackageService;
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
import javax.validation.constraints.Positive;
import java.net.URI;
import java.util.List;

@RestController
@Validated
@RequestMapping("/api/packages")
@Api(value = "PackageController")
@CrossOrigin(origins = "*", methods=
        {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.PATCH, RequestMethod.DELETE})
public class PackageController {

    private final IPackageService packageService;

    private final IPackageMapper packageMapper;

    public PackageController(IPackageService packageService,
                             IPackageMapper packageMapper) {
        this.packageService = packageService;
        this.packageMapper = packageMapper;
    }

    @PostMapping
    @ApiOperation(value = "Creates a new package")
    public ResponseEntity<PackageResponseDto> post(@RequestBody @Valid PackageRequestDto packageDto) {

        Package p = packageMapper.map(packageDto);
        Package result = packageService.post(p, packageDto.getOrdersIds());

        PackageResponseDto body = packageMapper.mapToDto(result);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(body.getId())
                .toUri();

        return ResponseEntity.created(location).body(body);
    }

    @GetMapping
    @ApiOperation(value = "Retrieves all packages")
    public ResponseEntity<List<PackageResponseDto>> getAll() {

        List<Package> packages = packageService.getAll();
        List<PackageResponseDto> body = packageMapper.mapToDto(packages);

        return ResponseEntity.ok(body);
    }

    @GetMapping(params = "cuit")
    @ApiOperation(value = "Retrieves all packages based on the given customer cuit")
    public ResponseEntity<List<PackageResponseDto>> getByCustomerCuit(@RequestParam(name = "cuit")
                                                                          @NotBlank
                                                                          @Length(min = 11, max = 11)
                                                                          @Mod11Check(threshold = 7) String cuit) {

        List<Package> packages = packageService.getByCustomerCuit(cuit);
        List<PackageResponseDto> body = packageMapper.mapToDto(packages);

        return ResponseEntity.ok(body);
    }

    @DeleteMapping(path = "/{id}")
    @ApiOperation(value = "Deletes a package based on the given id")
    public ResponseEntity<?> delete(@PathVariable @Positive Integer id) {

        packageService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
