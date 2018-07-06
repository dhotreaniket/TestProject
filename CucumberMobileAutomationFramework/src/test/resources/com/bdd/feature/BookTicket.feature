@LaunchApp
Feature: Book Ticket
     
  Scenario Outline: I want to book ticket
    Given Enter "<From Location>" "<To Location>" "<TicketType>" "<NumberOfAdults>" "<NumberOfChilds>"
    And "<DesiredHour>" "<Desired Minute>" "<DayNumber>" "<Month>" "<Year>"
    Then Select "<RailCard>" and click on find tickets and navigate to Select Train Page
    And Select Train for given "<FromTime>" and navigate To Select Ticket Page
    Then Select Ticket "<TicketType>" and navigate to Seats and Extras
    And Select Seat Reservation Option and navigate to Seats and Extras Page
    Then Select "<LikeToFace>" "<AisleSeat>" "<TableOrAirSeat>" "<Other>" option
    And Click on Confirm selection and navigate to Seats and Extras Page
    Then Click on Continue to Ticket delivery and click on Continue to Order Summary
    And Click on Go To CheckOut and enter Sign in Details if available
    And Go to To Payment Page and enter Card Details and click on Submit
    Then you will navigate to Booking Reference Page and get Booking Reference Number
    And Navigate to My Ticket Page, go to Booked Ticket and verify the Booking Refference Number

    Examples: Buy Page values
      | From Location | To Location           | TicketType | NumberOfAdults | NumberOfChilds | DesiredHour | Desired Minute | DayNumber | Month | Year | RailCard       | FromTime | TicketType  | LikeToFace | AisleSeat | TableOrAirSeat | Other           |
      | Leeds         | Manchester Piccadilly | Single     |              2 |              3 |          06 |             40 |        18 | Jul   | 2018 | 16-25 Railcard | 06:06    | Std Advance | Forwards   | Window    | Table seat     | Near toilet OFF |

      