Feature: Pantallas introductorias
  Como Usuario Tendero
  Quiero visualizar las pantallas con la informacion introductoria del producto
  Para que me permita redireccionar mi navegacion al registro de cuenta o inicio
  de sesion cada que no tenga una sesion iniciada.

  @intro
#    Background: El usuario tiene acceso a la app


  Scenario: Navegacion por las pantallas introductorias
    Given Elvis tiene acceso a la App de Mpos
    When el realiza el tutorial introductorio
    Then el deberia poder visualizar el home de app