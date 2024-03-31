# Tech Stack: Kotlin, MVVM, DI, Room, Navigation, coroutine, viewbinding, databinding, unit testing, ui testing

### Create a CurrencyListFragment that can be reused for different purposes, such as displaying Crypto Currency and Fiat Currency.
  - CurrencyListFragment will accept CurrencyInfo and display it with recyclerview
  - to allow reuse and expand, crytp currency and fiat currency will implement CurrencyInfo class. If there are new currency, it just need to implement currencyInfo then pass into fragment will be ok
### Additionally, create a DemoActivity to showcase the functionality of the CurrencyListFragment.
  - Activity will load fragment using navigation
### CurrencyListFragment is expected to receive an ArrayList of CurrencyInfo objects to create the UI
  - CurrencyListFragment will receive the list with bundle
### The DemoActivity should provide two datasets, Currency List A and Currency List B, which contain CurrencyInfo objects to be queried from the local database
  - DemoActivity will get data via the data class which store the test data as jsonString.
  - Data get will be in Fiat and Crypto model
  - CurrencyInfo is in DTO structure to be use RoomDB
### The first button is responsible for clearing the data in the local database
  - cleary data in RoomDB
### The second button is used to insert the data into the local database.
  - insert the display data into RoomDB
### The third button changes the CurrencyListFragment to use Currency List A -Crypto.
  - navigate to fragment with listA
### The fourth button changes the CurrencyListFragment to use Currency List B -Fiat.
  - navigate to fragment with listB
### The fifth button displays all CurrencyInfo objects that can be purchased fromCurrency List A and B.
  - navigate to fragment with listA and B
### Additionally, the CurrencyListFragment should provide a search feature that can be cancelled when the user clicks the back or close button.
### Furthermore, the CurrencyListFragment should include an empty view for displaying an empty list
### Lastly, it is crucial that all IO operations, including database or network access, are not performed on the UI Thread to ensure smooth execution
  - Date insert and clear will under coroutinescope
### Unit Testing
  - unit testing and ui test are implemented

