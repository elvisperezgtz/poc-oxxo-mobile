Feature: Formulario de registro

  Como Usuario
  Quiero ingresar en la pantalla inicial del proceso de onboarding mi numero telefonico
  Para que me permita solicitar el envio del codigo de verificacion via SMS/Mensaje de Texto.

#  Background: El usuario tiene acceso a la app

  Scenario: Validar telefono via SMS en Onboarding/Registro
    Given Elvis tiene acceso a la app Mpos por primera vez
    When Elvis realiza el tutorial introductorio
    And Elvis inicia el registro en la App con el numero de telefono "5223345634"
    Then Elvis deberia poder ver que el mensaje de envio del codigo SMS contine el numero registrado por el usuario

  @registro
  Scenario: Validar que el campo telefono admita solo numeros validos
    Given Elvis tiene acceso a la app Mpos por primera vez
    When Elvis realiza el tutorial introductorio
    And Elvis inicia el registro en la App con el numero de telefono "**#3345634"
    Then Elvis deberia poder ver que el mensaje de error "El número es inválido"
