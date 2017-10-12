$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri('cucumberJava\BorradoCuenta.feature');
formatter.feature({
  "line": 2,
  "name": "Usuario quiere borrar su cuenta",
  "description": "",
  "id": "usuario-quiere-borrar-su-cuenta",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 5,
  "name": "Borrado exitoso de cuenta",
  "description": "",
  "id": "usuario-quiere-borrar-su-cuenta;borrado-exitoso-de-cuenta",
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
  "name": "Usuario en pagina de \"borrado\"",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "\"password\" y \"passwordConf\" coinciden",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "Mensaje de \"exito\"",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "Envio a la pagina de \"inicio\"",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "Delete usuario de la base de datos",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "borrado",
      "offset": 22
    }
  ],
  "location": "annotation.Usuario_en_pagina_de(String)"
});
formatter.result({
  "duration": 1177304400,
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
  "duration": 4237300,
  "error_message": "junit.framework.ComparisonFailure: expected:\u003cpassword[]\u003e but was:\u003cpassword[Conf]\u003e\r\n\tat junit.framework.Assert.assertEquals(Assert.java:85)\r\n\tat junit.framework.Assert.assertEquals(Assert.java:91)\r\n\tat cucumberJava.annotation.y_coinciden(annotation.java:18)\r\n\tat ✽.When \"password\" y \"passwordConf\" coinciden(cucumberJava\\BorradoCuenta.feature:7)\r\n",
  "status": "failed"
});
formatter.match({
  "arguments": [
    {
      "val": "exito",
      "offset": 12
    }
  ],
  "location": "annotation.Mensaje_de(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "inicio",
      "offset": 22
    }
  ],
  "location": "annotation.Envio_a_la_pagina_de(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.scenario({
  "line": 13,
  "name": "Borrado fallido de cuenta",
  "description": "",
  "id": "usuario-quiere-borrar-su-cuenta;borrado-fallido-de-cuenta",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 12,
      "name": "@Scenario2"
    }
  ]
});
formatter.step({
  "line": 14,
  "name": "Usuario en pagina de \"borrado\"",
  "keyword": "Given "
});
formatter.step({
  "line": 15,
  "name": "\"password\" y \"passwordConf\" no coinciden",
  "keyword": "When "
});
formatter.step({
  "line": 16,
  "name": "Mensaje de \"error\"",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "borrado",
      "offset": 22
    }
  ],
  "location": "annotation.Usuario_en_pagina_de(String)"
});
formatter.result({
  "duration": 34200,
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
  "duration": 117900,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "error",
      "offset": 12
    }
  ],
  "location": "annotation.Mensaje_de(String)"
});
formatter.result({
  "duration": 137300,
  "status": "passed"
});
formatter.uri('cucumberJava\CreacionUsuario.feature');
formatter.feature({
  "line": 3,
  "name": "Creacion de un nuevo usuario",
  "description": "",
  "id": "creacion-de-un-nuevo-usuario",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 6,
  "name": "Creacion correcta de cuenta",
  "description": "",
  "id": "creacion-de-un-nuevo-usuario;creacion-correcta-de-cuenta",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 5,
      "name": "@Scenario1"
    }
  ]
});
formatter.step({
  "line": 7,
  "name": "Usuario en pagina de \"creacion\"",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "\"Nombre\" correcto",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "\"email\" correcto",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "\"password\" y \"passwordConf\" coinciden",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "Mensaje de \"validacion\"",
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "insertar usuario en base de datos",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "creacion",
      "offset": 22
    }
  ],
  "location": "annotation.Usuario_en_pagina_de(String)"
});
formatter.result({
  "duration": 5819500,
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
  "duration": 199700,
  "error_message": "cucumber.runtime.PendingException: TODO: implement me\r\n\tat cucumberJava.annotation.correcto(annotation.java:39)\r\n\tat ✽.When \"Nombre\" correcto(cucumberJava\\CreacionUsuario.feature:8)\r\n",
  "status": "pending"
});
formatter.match({
  "arguments": [
    {
      "val": "email",
      "offset": 1
    }
  ],
  "location": "annotation.correcto(String)"
});
formatter.result({
  "status": "skipped"
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
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "validacion",
      "offset": 12
    }
  ],
  "location": "annotation.Mensaje_de(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.scenario({
  "line": 16,
  "name": "Creacion incorrecta de cuenta",
  "description": "",
  "id": "creacion-de-un-nuevo-usuario;creacion-incorrecta-de-cuenta",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 15,
      "name": "@Scenario2"
    }
  ]
});
formatter.step({
  "line": 17,
  "name": "Usuario en pagina de \"creacion\"",
  "keyword": "Given "
});
formatter.step({
  "line": 18,
  "name": "\"password\" y \"passwordConf\" no coinciden",
  "keyword": "When "
});
formatter.step({
  "line": 19,
  "name": "Mensaje de \"error\"",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "creacion",
      "offset": 22
    }
  ],
  "location": "annotation.Usuario_en_pagina_de(String)"
});
formatter.result({
  "duration": 44700,
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
  "duration": 34900,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "error",
      "offset": 12
    }
  ],
  "location": "annotation.Mensaje_de(String)"
});
formatter.result({
  "duration": 98300,
  "status": "passed"
});
formatter.uri('cucumberJava\Desconexion.feature');
formatter.feature({
  "line": 2,
  "name": "Usuario quiere desconectarse",
  "description": "",
  "id": "usuario-quiere-desconectarse",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 5,
  "name": "Desconexion exitosa",
  "description": "",
  "id": "usuario-quiere-desconectarse;desconexion-exitosa",
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
  "name": "Usuario en pagina de \"home\"",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "Usuario selecciona \"desconectar\"",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "Mensaje de \"exito\"",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "Envio a la pagina de \"inicio\"",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "home",
      "offset": 22
    }
  ],
  "location": "annotation.Usuario_en_pagina_de(String)"
});
formatter.result({
  "duration": 11571000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "desconectar",
      "offset": 20
    }
  ],
  "location": "annotation.Usuario_selecciona(String)"
});
formatter.result({
  "duration": 137900,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "exito",
      "offset": 12
    }
  ],
  "location": "annotation.Mensaje_de(String)"
});
formatter.result({
  "duration": 35300,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "inicio",
      "offset": 22
    }
  ],
  "location": "annotation.Envio_a_la_pagina_de(String)"
});
formatter.result({
  "duration": 22500,
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
  "name": "Usuario en pagina de \"login\"",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "Pone nombre de \"usuario\" y \"password\" validos",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "llegamos a la pagina inicial y un \"mensaje\" de bienvenida",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "login",
      "offset": 22
    }
  ],
  "location": "annotation.Usuario_en_pagina_de(String)"
});
formatter.result({
  "duration": 6668200,
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
  "duration": 143100,
  "error_message": "java.lang.Error: Unresolved compilation problem: \n\tUserDAO cannot be resolved\n\r\n\tat cucumberJava.annotation.Pone_nombre_de_y_validos(annotation.java:49)\r\n\tat ✽.When Pone nombre de \"usuario\" y \"password\" validos(cucumberJava\\Login.feature:7)\r\n",
  "status": "failed"
});
formatter.match({
  "arguments": [
    {
      "val": "mensaje",
      "offset": 35
    }
  ],
  "location": "annotation.llegamos_a_la_pagina_inicial_y_un_de_bienvenida(String)"
});
formatter.result({
  "status": "skipped"
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
  "name": "Usuario en pagina de \"login\"",
  "keyword": "Given "
});
formatter.step({
  "line": 13,
  "name": "Pone nombre de \"usuario\" y/o \"password\" invalidos",
  "keyword": "When "
});
formatter.step({
  "line": 14,
  "name": "Mensaje de \"error\"",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "login",
      "offset": 22
    }
  ],
  "location": "annotation.Usuario_en_pagina_de(String)"
});
formatter.result({
  "duration": 32800,
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
  "duration": 223800,
  "error_message": "java.lang.Error: Unresolved compilation problem: \n\tUserDAO cannot be resolved\n\r\n\tat cucumberJava.annotation.Pone_nombre_de_y_o_invalidos(annotation.java:59)\r\n\tat ✽.When Pone nombre de \"usuario\" y/o \"password\" invalidos(cucumberJava\\Login.feature:13)\r\n",
  "status": "failed"
});
formatter.match({
  "arguments": [
    {
      "val": "error",
      "offset": 12
    }
  ],
  "location": "annotation.Mensaje_de(String)"
});
formatter.result({
  "status": "skipped"
});
});