package poo.phoneoperatormanager.cli.operator_management_menu.commands.utils;

import poo.phoneoperatormanager.domain.operator.AgencyType;

public class AgencyTypeIndexMapper {
    
    public static AgencyType getTypeOfIndex(String index) {
        return switch (index) {
            case "1" -> AgencyType.PRIMARY;
            case "2" -> AgencyType.SECONDARY;
            default -> throw new InvalidAgencyIndexException();
        };
    }
    
    
    private static class InvalidAgencyIndexException extends RuntimeException {
    
    }
}
