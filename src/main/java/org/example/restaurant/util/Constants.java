package org.example.restaurant.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public final class Constants {

    public static final String MAIN_MENU = """
                
                if you want meal, please enter 1
                if you want drink, please enter 2
                if you want finalize an order, please enter 3
                if you want get orders, enter your password
                if you want exit, please enter 0
                
                """;

    public static final String CUISINE_CHO = """
                                choose a cuisine:
                                Polish(1)
                                Mexican(2)
                                Italian(3)
                                return to main menu(any other button)""";

    public static final String TYPE_MEAL = """
                                choose a type meal:
                                Course(1)
                                Dessert(2)
                                return to main menu(any other button)""";
}
