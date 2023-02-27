package com.swil.userservice.core.enums;

public enum UserRoleEnums {
    ADMIN((short)1), MANAGER((short)2), USER((short)3);

    private Short value;

    UserRoleEnums(Short value){
        this.value = value;
    }

    public static UserRoleEnums fromValue(Short value) {
		if (value != null) {
			for (UserRoleEnums role : values()) {
				if (role.value.equals(value)) {
					return role;
				}
			}
		}
		throw new IllegalArgumentException("Invalid RoleType: " + value);
	}

	public Short getValue() {
		return value;
	}
}
