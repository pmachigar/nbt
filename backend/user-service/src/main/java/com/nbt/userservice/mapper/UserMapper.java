package com.nbt.userservice.mapper;

import com.nbt.proto.user.Address;
import com.nbt.proto.user.Contact;
import com.nbt.proto.user.CreateUserRequest;
import com.nbt.proto.user.UserResponse;
import com.nbt.userservice.domain.User;

public class UserMapper {

    public static User toDomain(CreateUserRequest request) {
        User user = new User();
        user.setIdDocumento(request.getIdDocumento());
        user.setNombre(request.getNombre());
        user.setDireccion(toDomain(request.getDireccion()));
        user.setContacto(toDomain(request.getContacto()));
        return user;
    }

    public static UserResponse toProto(User user) {
        return UserResponse.newBuilder()
                .setId(user.getId() != null ? user.getId() : "")
                .setIdDocumento(user.getIdDocumento())
                .setNombre(user.getNombre())
                .setDireccion(toProto(user.getDireccion()))
                .setContacto(toProto(user.getContacto()))
                .build();
    }

    private static User.Address toDomain(Address proto) {
        if (proto == null)
            return null;
        User.Address domain = new User.Address();
        domain.setPais(proto.getPais());
        domain.setCiudad(proto.getCiudad());
        domain.setRegion(proto.getRegion());
        domain.setComuna(proto.getComuna());
        domain.setCalle(proto.getCalle());
        domain.setNumero(proto.getNumero());
        domain.setPiso(proto.getPiso());
        domain.setApartamento(proto.getApartamento());
        domain.setBlock(proto.getBlock());
        domain.setZona(proto.getZona());
        return domain;
    }

    private static Address toProto(User.Address domain) {
        if (domain == null)
            return Address.getDefaultInstance();
        return Address.newBuilder()
                .setPais(domain.getPais())
                .setCiudad(domain.getCiudad())
                .setRegion(domain.getRegion())
                .setComuna(domain.getComuna())
                .setCalle(domain.getCalle())
                .setNumero(domain.getNumero())
                .setPiso(domain.getPiso())
                .setApartamento(domain.getApartamento())
                .setBlock(domain.getBlock())
                .setZona(domain.getZona())
                .build();
    }

    private static User.Contact toDomain(Contact proto) {
        if (proto == null)
            return null;
        User.Contact domain = new User.Contact();
        domain.setTelefono(proto.getTelefono());
        domain.setEmail(proto.getEmail());
        domain.setInstagram(proto.getInstagram());
        domain.setFacebook(proto.getFacebook());
        return domain;
    }

    private static Contact toProto(User.Contact domain) {
        if (domain == null)
            return Contact.getDefaultInstance();
        return Contact.newBuilder()
                .setTelefono(domain.getTelefono())
                .setEmail(domain.getEmail())
                .setInstagram(domain.getInstagram())
                .setFacebook(domain.getFacebook())
                .build();
    }
}
