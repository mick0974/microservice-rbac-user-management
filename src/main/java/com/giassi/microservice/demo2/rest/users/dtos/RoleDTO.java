package com.giassi.microservice.demo2.rest.users.dtos;

import com.giassi.microservice.demo2.rest.users.entities.Role;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Data
public class RoleDTO implements Serializable {

    private Long roleId;
    private String role;

    private List<PermissionDTO> permissions = new ArrayList<>();

    public RoleDTO(Role role) {
        this.roleId = role.getRoleId();
        this.role = role.getRole();

        // permissions
        role.getPermissions().stream().forEach(e -> permissions.add(new PermissionDTO(e)));
    }

    public RoleDTO(Long roleId, String role) {
        this.roleId = roleId;
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RoleDTO)) return false;
        return roleId != null && roleId.equals(((RoleDTO) o).getRoleId());
    }

    @Override
    public int hashCode() {
        return 31;
    }

}
