Feature: Logear Usuario por Tipo Perfil
Background: Portal de Logeo se encuentra abierto

  @LogearJuridicaJuridicaPrincipal
  Scenario Outline: login a user
    Given page of login MR2 is all ready
    When user enters credentials "<email>" and "<password>"
    Then user can see MR2 page

    Examples: 
      | email                  |  | password  |
      | backus@gmail.com       |  | Vuce0424. |