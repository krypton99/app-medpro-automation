Feature: Homepage
  Label is used to determine all homepage features

  Background: 
    Given User open Medpro application

  @verify_homepage_ui
  Scenario: Assert homepage attribute
    And User choose language "vietnamese"
    And User close popup banner
    Then User should see feature section
    And User should see associated hospital section
    And User should see banner section
    And User should see recommended hospital section
    And User should see telemedicine doctor section
    And User should see comprehensive medical bundle section

  @cskh_phone
  Scenario Outline: Assert cskh button
    And User choose language "vietnamese"
    And User close popup banner
    And User tap on cskh button
    And User tap on cskh "<option>"
    And User should see "<application>" opened

    Examples: 
      | option    | application |
      | phone     | zalo        |
      | messenger | messenger   |
      | zalo      | zalo        |
  #@add_to_cart
  #Scenario: Verify buttons displays on product page
    #And User search "dien thoai"
    #When User click on the first product
    #Then User should see button "Thêm vào giỏ"
    #And User should see button "Mua ngay"
    #And User should see button "Mua trả góp - trả sau"
#
  #@interested
  #Scenario: Verify section "Đơn hàng của tôi" displays correctly
    #And User tap Tài khoản
    #When User swipe to Quan tâm section
    #Then User should see item: "Đã xem"
    #And User should see item: "Yêu thích"
    #And User should see item: "Mua lại"
#
  #@title
  #Scenario Outline: Verify section "Đơn hàng của tôi" displays correctly
    #And User click on Danh mục
    #When User click on "<CategoryItem>"
    #Then User should see the "<CategoryTitle>" on the right side
    #And User should see the first section "<firstSectionName>"
#
    #Examples: 
      #| CategoryItem               | CategoryTitle              | firstSectionName      |
      #| Nhà Sách Tiki              | Nhà Sách Tiki              | Danh mục phổ biến     |
      #| Nhà Cửa - Đời Sống         | Nhà Cửa - Đời Sống         | Danh mục phổ biến     |
      #| Điện Thoại - Máy Tính Bảng | Điện Thoại - Máy Tính Bảng | Điện thoại Smartphone |
      #| Đồ Chơi - Mẹ & Bé          | Đồ Chơi - Mẹ & Bé          | Tã, Bỉm               |
