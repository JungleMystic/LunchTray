package com.lrm.lunchtray.data

import com.lrm.lunchtray.constants.ItemType
import com.lrm.lunchtray.model.MenuItem

object DataSource {

    val menuItems = mapOf(
        "mc1" to
                MenuItem(
                    name = "Cauliflower",
                    description = "Whole cauliflower, brined, roasted, and deep fried",
                    price = 110,
                    type = ItemType.MAIN_COURSE,
                    code = "mc1"
                ),
        "mc2" to
                MenuItem(
                    name = "Three Bean Chili",
                    description = "Black beans, red beans, kidney beans, slow cooked, topped with onion",
                    price = 140,
                    type = ItemType.MAIN_COURSE,
                    code = "mc2"
                ),
        "mc3" to
                MenuItem(
                    name = "Mushroom Pasta",
                    description = "Penne pasta, mushrooms, basil, with plum tomatoes cooked in garlic and " +
                            "olive oil",
                    price = 150,
                    type = ItemType.MAIN_COURSE,
                    code = "mc3"
                ),
        "mc4" to
                MenuItem(
                    name = "Spicy Black Bean Skillet",
                    description = "Seasonal vegetables, black beans, house spice blend, served with avocado " +
                            "and quick pickled onions",
                    price = 200,
                    type = ItemType.MAIN_COURSE,
                    code = "mc4"
                ),
        "sd1" to
                MenuItem(
                    name = "Summer Salad",
                    description = "Heirloom tomatoes, butter lettuce, peaches, avocado, balsamic dressing",
                    price = 120,
                    type = ItemType.SIDE_DISH,
                    code = "sd1"
                ),
        "sd2" to
                MenuItem(
                    name = "Butternut Squash Soup",
                    description = "Roasted butternut squash, roasted peppers, chili oil",
                    price = 70,
                    type = ItemType.SIDE_DISH,
                    code = "sd2"
                ),
        "sd3" to
                MenuItem(
                    name = "Spicy Potatoes",
                    description = "Marble potatoes, roasted, and fried in house spice blend",
                    price = 85,
                    type = ItemType.SIDE_DISH,
                    code = "sd3"
                ),
        "sd4" to
                MenuItem(
                    name = "Coconut Rice",
                    description = "Rice, coconut milk, lime, and sugar",
                    price = 95,
                    type = ItemType.SIDE_DISH,
                    code = "sd4"
                ),
        "snack1" to
                MenuItem(
                    name = "Lunch Roll",
                    description = "Fresh baked roll made in house",
                    price = 50,
                    type = ItemType.SNACKS,
                    code = "snack1"
                ),
        "snack2" to
                MenuItem(
                    name = "Mixed Berries",
                    description = "Strawberries, blueberries, raspberries, and huckleberries",
                    price = 40,
                    type = ItemType.SNACKS,
                    code = "snack2"
                ),
        "snack3" to
                MenuItem(
                    name = "Pickled Veggies",
                    description = "Pickled cucumbers and carrots, made in house",
                    price = 60,
                    type = ItemType.SNACKS,
                    code = "snack3"
                )
    )
}