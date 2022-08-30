package com.project.storemanagement.Models;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "enum_rolname")
public enum Enum_RoleName {
    admim,
    operario;
}
