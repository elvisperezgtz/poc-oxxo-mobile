Feature: Formulario de registro

  Como Usuario
  Quiero ingresar en la pantalla inicial del proceso de onboarding mi numero telefonico
  Para que me permita solicitar el envio del codigo de verificacion via SMS/Mensaje de Texto.


@registro
  Scenario: Envio de SMS
    Given Elvis tiene acceso a la app Mpos por primera vez
    When Elvis realiza el tutorial introductorio
    And Elvis inicia el registro en la App con el numero de telefono "5223345634"