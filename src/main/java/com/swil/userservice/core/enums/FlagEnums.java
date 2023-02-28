package com.swil.userservice.core.enums;

public enum FlagEnums {
    NO((short)0), YES((short)1);

    private Short value;

    FlagEnums(Short value){
        this.value = value;
    }

    public static FlagEnums fromValue(Short value) {
		if (value != null) {
			for (FlagEnums role : values()) {
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
