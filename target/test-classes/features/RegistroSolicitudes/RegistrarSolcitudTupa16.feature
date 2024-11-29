Feature: Registrar una nueva Solicitud
Background: Portal de Home Principal se encuentra abierto

  @RegistrarSolicitudTupa16
  Scenario Outline: create a solicitud with tupa 16
    Given page of MR2 is all ready
    When user select iniciar solicitud button 
    And user select ipen entity
    And register new solicitud "<representante>" and "<informacionautorizacion>" and "<tipofuente>" and "<usoespecifico>" and "<cantidad>"   
    Then user can see solicitud transmitida exitosamente message
    
    Examples: 
      | representante                  |  | informacionautorizacion                                             |  | tipofuente                     |  | usoespecifico            |  | cantidad |
      | YCHOCAN CUELLAR SONIA ANGELICA |  | Importación y/o comercialización de fuentes de radiación ionizante. |  | Acelerador lineal              |  | Mamografía               |  | 5        |