@AddProductsToCartAndCheckout
Feature: Add Products To Cart And Checkout

Background: User Logs In
    Given User navigate to the login page
        When User submits username and password
        Then User should be logged in

    Scenario Outline: Add Products To Cart And Checkout
        Given User Add Products "<productsList>" To Cart
        When User goes to cart
        Then Confirm Correct Products "<productsList>" Are Added To Cart
        Then User Inputs Checkout Information "<firstName>", "<lastName>", "<zipCode>"
        Then Confirm Total Price On Checkout Overview Screen
        Then Finish Order
        Then Confirm Order Confirmation Screen

        Examples:
            | productsList                                        | firstName | lastName | zipCode |
            | Sauce Labs Backpack,Sauce Labs Bike Light           | Adroit    | Mkhari   | 1459    |
            | Sauce Labs Bolt T-Shirt,Sauce Labs Fleece Jacket    | Nseketelo | Mkhari   | 0871    |
            | Sauce Labs Onesie,Test.allTheThings() T-Shirt (Red) | Rivoningo | Mkhari   | 1861    |