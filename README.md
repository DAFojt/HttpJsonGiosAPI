# HttpJsonGiosAPI

API pobierające dane na temat jakości powietrza z WebService GIOŚ poprzez HTTP w formacie JSON, parsujące pobrane dane do obiektów poniższych klas, ich pól, oraz grupujące ewentualne dane grupowe do ArrayList. Prosty podgląd pobranych danych zaimplementowany w SWING w formie tabelarycznej.

API udostępnia metody umożliwiające automatyczne pobranie danych na temat jakości powietrza z serwisu Głównego Inspektoratu Ochrony Środowiska http://www.gios.gov.pl/pl/ 

ReadMe w trakcie przygotowywania.

Główne udostępnione klasy i ich metody:

Stations - Klasa przechowująca dane na temat stacji pomiarowych, udostępniająca podstawowe metody get/set oraz metody dodatkowe służące do pobrania informacji dodatkowych o stacji
Metody niestandardowe:

getAllSensorsByHttp(); - Metoda pobierająca informacje o wszystkich dostępnych sensorach dla danej stacji pomiarowej 

Sensors - Klasa przechowująca dane na temat sensora danej stacji pomiarowej, udostępniająca podstawowe metody get/set oraz metody dodatkowe
Metody niestandardowe:

getDataByHttp(); - Metoda służąca do pobrania wszystkich dostępnych danych pomiarowych dla danego sensora

Dane pobrane dla stacji pomiarowch przechowywane są w postaci ArrayList tablicy String


Metoda zwracająca ArrayList obiektów klasy Station wszystkich dostępnych na GIOŚ stacji pomiarowych
GetByFindAll.getArrayListByFindAll();
