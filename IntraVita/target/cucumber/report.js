$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri('cucumberJava\BorradoCuenta.feature');
formatter.feature({
  "line": 1,
  "name": "Usuario quiere borrar su cuenta",
  "description": "",
  "id": "usuario-quiere-borrar-su-cuenta",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 4,
  "name": "Borrado exitoso de cuenta",
  "description": "",
  "id": "usuario-quiere-borrar-su-cuenta;borrado-exitoso-de-cuenta",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 3,
      "name": "@Scenario1"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "Usuario en pagina de borrado",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "\"password\" y \"passwordConf\" coinciden y son validos",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "Mensaje de exito y delete del usuario",
  "keyword": "Then "
});
formatter.match({
  "location": "annotation.Usuario_en_pagina_de_borrado()"
});
formatter.result({
  "duration": 309078149,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "password",
      "offset": 1
    },
    {
      "val": "passwordConf",
      "offset": 14
    }
  ],
  "location": "annotation.y_coinciden_y_son_validos(String,String)"
});
formatter.result({
  "duration": 4049506068,
  "status": "passed"
});
formatter.match({
  "location": "annotation.Mensaje_de_exito_y_delete_del_usuario()"
});
formatter.result({
  "duration": 148079817,
  "status": "passed"
});
formatter.scenario({
  "line": 10,
  "name": "Borrado fallido de cuenta",
  "description": "",
  "id": "usuario-quiere-borrar-su-cuenta;borrado-fallido-de-cuenta",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 9,
      "name": "@Scenario2"
    }
  ]
});
formatter.step({
  "line": 11,
  "name": "Usuario en pagina de",
  "keyword": "Given "
});
formatter.step({
  "line": 12,
  "name": "\"password\" y \"passwordConf\" no coinciden o son invalidos",
  "keyword": "When "
});
formatter.step({
  "line": 13,
  "name": "Mensaje de error y cancelacion del borrado",
  "keyword": "Then "
});
formatter.match({
  "location": "annotation.Usuario_en_pagina_de()"
});
formatter.result({
  "duration": 30789,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "password",
      "offset": 1
    },
    {
      "val": "passwordConf",
      "offset": 14
    }
  ],
  "location": "annotation.y_no_coinciden_o_son_invalidos(String,String)"
});
formatter.result({
  "duration": 54849807,
  "status": "passed"
});
formatter.match({
  "location": "annotation.Mensaje_de_error_y_cancelacion_del_borrado()"
});
formatter.result({
  "duration": 22970,
  "status": "passed"
});
formatter.uri('cucumberJava\CreacionUsuario.feature');
formatter.feature({
  "line": 1,
  "name": "Creacion de un nuevo usuario",
  "description": "",
  "id": "creacion-de-un-nuevo-usuario",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 4,
  "name": "Creacion correcta de cuenta",
  "description": "",
  "id": "creacion-de-un-nuevo-usuario;creacion-correcta-de-cuenta",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 3,
      "name": "@Scenario1"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "Usuario en pagina de creacion",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "\"Nombre\" correcto",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "\"password\" y \"passwordConf\" coinciden",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "Mensaje de validacion y usuario insertado",
  "keyword": "Then "
});
formatter.match({
  "location": "annotation.Usuario_en_pagina_de_creacion()"
});
formatter.result({
  "duration": 5281182,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Nombre",
      "offset": 1
    }
  ],
  "location": "annotation.correcto(String)"
});
formatter.result({
  "duration": 151506,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "password",
      "offset": 1
    },
    {
      "val": "passwordConf",
      "offset": 14
    }
  ],
  "location": "annotation.y_coinciden(String,String)"
});
formatter.result({
  "duration": 54737,
  "status": "passed"
});
formatter.match({
  "location": "annotation.Mensaje_de_validacion_y_usuario_insertado()"
});
formatter.result({
  "duration": 575741166,
  "status": "passed"
});
formatter.scenario({
  "line": 12,
  "name": "Creacion incorrecta de cuenta",
  "description": "",
  "id": "creacion-de-un-nuevo-usuario;creacion-incorrecta-de-cuenta",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 11,
      "name": "@Scenario2"
    }
  ]
});
formatter.step({
  "line": 13,
  "name": "Usuario en pagina de creacion",
  "keyword": "Given "
});
formatter.step({
  "line": 14,
  "name": "\"password\" y \"passwordConf\" no coinciden",
  "keyword": "When "
});
formatter.step({
  "line": 15,
  "name": "Mensaje de error2",
  "keyword": "Then "
});
formatter.match({
  "location": "annotation.Usuario_en_pagina_de_creacion()"
});
formatter.result({
  "duration": 60113,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "password",
      "offset": 1
    },
    {
      "val": "passwordConf",
      "offset": 14
    }
  ],
  "location": "annotation.y_no_coinciden(String,String)"
});
formatter.result({
  "duration": 135377,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "2",
      "offset": 16
    }
  ],
  "location": "annotation.Mensaje_de_error(int)"
});
formatter.result({
  "duration": 57605737,
  "status": "passed"
});
formatter.uri('cucumberJava\Login.feature');
formatter.feature({
  "line": 1,
  "name": "Logeo al sistema",
  "description": "",
  "id": "logeo-al-sistema",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 5,
  "name": "Login exitoso con credenciales validas",
  "description": "",
  "id": "logeo-al-sistema;login-exitoso-con-credenciales-validas",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 4,
      "name": "@Scenario1"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "Usuario en pagina de login",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "Pone nombre de \"usuario\" y \"password\" validos",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "llegamos a la pagina inicial y un mensaje de bienvenida",
  "keyword": "Then "
});
formatter.match({
  "location": "annotation.Usuario_en_pagina_de_login()"
});
formatter.result({
  "duration": 6112018,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "usuario",
      "offset": 16
    },
    {
      "val": "password",
      "offset": 28
    }
  ],
  "location": "annotation.Pone_nombre_de_y_validos(String,String)"
});
formatter.result({
  "duration": 59740496,
  "status": "passed"
});
formatter.match({
  "location": "annotation.llegamos_a_la_pagina_inicial_y_un_mensaje_de_bienvenida()"
});
formatter.result({
  "duration": 62532104,
  "status": "passed"
});
formatter.scenario({
  "line": 11,
  "name": "Login fallido por credenciales invalidas",
  "description": "",
  "id": "logeo-al-sistema;login-fallido-por-credenciales-invalidas",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 10,
      "name": "@Scenario2"
    }
  ]
});
formatter.step({
  "line": 12,
  "name": "Usuario en pagina de login",
  "keyword": "Given "
});
formatter.step({
  "line": 13,
  "name": "Pone nombre de \"usuario\" y/o \"password\" invalidos",
  "keyword": "When "
});
formatter.step({
  "line": 14,
  "name": "Mensaje de error",
  "keyword": "Then "
});
formatter.match({
  "location": "annotation.Usuario_en_pagina_de_login()"
});
formatter.result({
  "duration": 24925,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "usuario",
      "offset": 16
    },
    {
      "val": "password",
      "offset": 30
    }
  ],
  "location": "annotation.Pone_nombre_de_y_o_invalidos(String,String)"
});
formatter.result({
  "duration": 58159,
  "status": "passed"
});
formatter.match({
  "location": "annotation.Mensaje_de_error()"
});
formatter.result({
  "duration": 54390404,
  "status": "passed"
});
});