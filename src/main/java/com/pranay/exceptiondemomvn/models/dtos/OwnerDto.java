package com.pranay.exceptiondemomvn.models.dtos;

import com.pranay.exceptiondemomvn.models.Owner;

import java.util.Set;
import java.util.stream.Collectors;

public class OwnerDto implements DtoTransformer<Owner> {
	private Long id;
	private String name;
	private Set<CarDto> cars;
	private Long version;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<CarDto> getCars() {
		return cars;
	}

	public void setCars(Set<CarDto> cars) {
		this.cars = cars;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	@Override
	public Owner convertToEntity() {
		Owner owner = new Owner();
		owner.setId(this.getId());
		owner.setName(this.getName());
		if (this.getVersion() != null) owner.setVersion(this.getVersion());
		if (this.getCars() != null) owner.setCars(this.getCars().stream().map(CarDto::convertToEntity).collect(Collectors.toSet()));
		return owner;
	}
}
