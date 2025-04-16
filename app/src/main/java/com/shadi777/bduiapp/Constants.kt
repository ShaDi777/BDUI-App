package com.shadi777.bduiapp

val mainMenu = """
{
    "type": "Column",
    "layout": {
        "width": {
            "type": "Match"
        },
        "height": {
            "type": "Match"
        },
        "padding": {
            "top": "L",
            "left": "L",
            "right": "L",
            "bottom": "L"
        }
    },
    "children": [
        {
            "text": "Главное меню",
            "type": "Label",
            "layout": {
                "margin": {
                    "left": "XXL",
                    "bottom": "XXXL"
                }
            },
            "typography": "H3"
        },
        {
            "text": "Перейти к Button Showcase",
            "type": "Button",
            "style": "FILLED",
            "action": {
                "type": "navigate",
                "route": "#button-showcase"
            },
            "layout": {
                "width": {
                    "type": "Match"
                },
                "height": {
                    "type": "Wrap"
                },
                "margin": {
                    "top": "XXXL"
                },
                "padding": {
                    "top": "XL",
                    "left": "M",
                    "right": "M",
                    "bottom": "XL"
                }
            },
            "typography": "BODY2",
            "colorScheme": "PRIMARY"
        },
        {
            "text": "Перейти к Input Showcase",
            "type": "Button",
            "style": "FILLED",
            "action": {
                "type": "navigate",
                "route": "#input-showcase"
            },
            "layout": {
                "width": {
                    "type": "Match"
                },
                "height": {
                    "type": "Wrap"
                },
                "margin": {
                    "top": "XXXL"
                },
                "padding": {
                    "top": "XL",
                    "left": "M",
                    "right": "M",
                    "bottom": "XL"
                }
            },
            "typography": "BODY2",
            "colorScheme": "PRIMARY"
        },
        {
            "text": "Перейти к Label showcase",
            "type": "Button",
            "style": "FILLED",
            "action": {
                "type": "navigate",
                "route": "#label-showcase"
            },
            "layout": {
                "width": {
                    "type": "Match"
                },
                "height": {
                    "type": "Wrap"
                },
                "margin": {
                    "top": "XXXL"
                },
                "padding": {
                    "top": "XL",
                    "left": "M",
                    "right": "M",
                    "bottom": "XL"
                }
            },
            "typography": "BODY2",
            "colorScheme": "PRIMARY"
        },
        {
            "text": "Перейти к Icon showcase",
            "type": "Button",
            "style": "FILLED",
            "action": {
                "type": "navigate",
                "route": "#icon-showcase"
            },
            "layout": {
                "width": {
                    "type": "Match"
                },
                "height": {
                    "type": "Wrap"
                },
                "margin": {
                    "top": "XXXL"
                },
                "padding": {
                    "top": "XL",
                    "left": "M",
                    "right": "M",
                    "bottom": "XL"
                }
            },
            "typography": "BODY2",
            "colorScheme": "PRIMARY"
        },
        {
            "text": "Перейти к Slider showcase",
            "type": "Button",
            "style": "FILLED",
            "action": {
                "type": "navigate",
                "route": "#slider-showcase"
            },
            "layout": {
                "width": {
                    "type": "Match"
                },
                "height": {
                    "type": "Wrap"
                },
                "margin": {
                    "top": "XXXL"
                },
                "padding": {
                    "top": "XL",
                    "left": "M",
                    "right": "M",
                    "bottom": "XL"
                }
            },
            "typography": "BODY2",
            "colorScheme": "PRIMARY"
        },
        {
            "text": "Перейти к test-sample",
            "type": "Button",
            "style": "OUTLINED",
            "action": {
                "type": "navigate",
                "route": "#test-sample"
            },
            "layout": {
                "width": {
                    "type": "Match"
                },
                "height": {
                    "type": "Wrap"
                },
                "margin": {
                    "top": "XXXL"
                },
                "padding": {
                    "top": "XL",
                    "left": "M",
                    "right": "M",
                    "bottom": "XL"
                }
            },
            "typography": "BODY2",
            "colorScheme": "PRIMARY"
        }
    ]
}
""".trimIndent()

val buttonShowcase = """
{
    "type": "Column",
    "layout": {
        "width": {
            "type": "Match"
        },
        "height": {
            "type": "Match"
        },
        "padding": {
            "top": "L",
            "left": "L",
            "right": "L",
            "bottom": "L"
        }
    },
    "children": [
        {
            "type": "Row",
            "layout": {
                "width": {
                    "type": "Match"
                },
                "margin": {
                    "bottom": "XXL"
                }
            },
            "children": [
                {
                    "text": "Primary Filled",
                    "type": "Button",
                    "style": "FILLED",
                    "action": {
                        "type": "toast",
                        "message": "Primary Filled"
                    },
                    "layout": {
                        "width": {
                            "type": "Wrap"
                        },
                        "height": {
                            "type": "Wrap"
                        },
                        "margin": {
                            "right": "S"
                        },
                        "weight": 1.0,
                        "padding": {
                            "top": "L",
                            "left": "M",
                            "right": "M",
                            "bottom": "L"
                        }
                    },
                    "colorScheme": "PRIMARY"
                },
                {
                    "text": "Primary Outlined",
                    "type": "Button",
                    "style": "OUTLINED",
                    "action": {
                        "type": "toast",
                        "message": "Primary Outlined"
                    },
                    "layout": {
                        "width": {
                            "type": "Wrap"
                        },
                        "height": {
                            "type": "Wrap"
                        },
                        "margin": {
                            "left": "S",
                            "right": "S"
                        },
                        "weight": 1.0,
                        "padding": {
                            "top": "L",
                            "left": "M",
                            "right": "M",
                            "bottom": "L"
                        }
                    },
                    "colorScheme": "PRIMARY"
                },
                {
                    "text": "Primary Text",
                    "type": "Button",
                    "style": "TEXT",
                    "action": {
                        "type": "toast",
                        "message": "Primary Text"
                    },
                    "layout": {
                        "width": {
                            "type": "Wrap"
                        },
                        "height": {
                            "type": "Wrap"
                        },
                        "margin": {
                            "left": "S"
                        },
                        "weight": 1.0,
                        "padding": {
                            "top": "L",
                            "left": "M",
                            "right": "M",
                            "bottom": "L"
                        }
                    },
                    "colorScheme": "PRIMARY"
                }
            ]
        },
        {
            "type": "Row",
            "layout": {
                "width": {
                    "type": "Match"
                },
                "margin": {
                    "top": "XL",
                    "bottom": "L"
                }
            },
            "children": [
                {
                    "text": "Danger Filled",
                    "type": "Button",
                    "style": "FILLED",
                    "action": {
                        "type": "toast",
                        "message": "Danger Filled"
                    },
                    "layout": {
                        "width": {
                            "type": "Wrap"
                        },
                        "height": {
                            "type": "Wrap"
                        },
                        "margin": {
                            "right": "S"
                        },
                        "weight": 1.0,
                        "padding": {
                            "top": "L",
                            "left": "M",
                            "right": "M",
                            "bottom": "L"
                        }
                    },
                    "colorScheme": "DANGER"
                },
                {
                    "text": "Warning Filled",
                    "type": "Button",
                    "style": "FILLED",
                    "action": {
                        "type": "toast",
                        "message": "Warning Filled"
                    },
                    "layout": {
                        "width": {
                            "type": "Wrap"
                        },
                        "height": {
                            "type": "Wrap"
                        },
                        "margin": {
                            "left": "S",
                            "right": "S"
                        },
                        "weight": 1.0,
                        "padding": {
                            "top": "L",
                            "left": "M",
                            "right": "M",
                            "bottom": "L"
                        }
                    },
                    "colorScheme": "WARNING"
                },
                {
                    "text": "Positive Filled",
                    "type": "Button",
                    "style": "FILLED",
                    "action": {
                        "type": "toast",
                        "message": "Positive Filled"
                    },
                    "layout": {
                        "width": {
                            "type": "Wrap"
                        },
                        "height": {
                            "type": "Wrap"
                        },
                        "margin": {
                            "left": "S"
                        },
                        "weight": 1.0,
                        "padding": {
                            "top": "L",
                            "left": "M",
                            "right": "M",
                            "bottom": "L"
                        }
                    },
                    "colorScheme": "POSITIVE"
                }
            ]
        },
        {
            "type": "Row",
            "layout": {
                "width": {
                    "type": "Match"
                },
                "margin": {
                    "top": "L",
                    "bottom": "L"
                }
            },
            "children": [
                {
                    "text": "Danger Outlined",
                    "type": "Button",
                    "style": "OUTLINED",
                    "action": {
                        "type": "toast",
                        "message": "Danger Outlined"
                    },
                    "layout": {
                        "width": {
                            "type": "Wrap"
                        },
                        "height": {
                            "type": "Wrap"
                        },
                        "margin": {
                            "right": "S"
                        },
                        "weight": 1.0,
                        "padding": {
                            "top": "L",
                            "left": "M",
                            "right": "M",
                            "bottom": "L"
                        }
                    },
                    "colorScheme": "DANGER"
                },
                {
                    "text": "Warning Outlined",
                    "type": "Button",
                    "style": "OUTLINED",
                    "action": {
                        "type": "toast",
                        "message": "Warning Outlined"
                    },
                    "layout": {
                        "width": {
                            "type": "Wrap"
                        },
                        "height": {
                            "type": "Wrap"
                        },
                        "margin": {
                            "left": "S",
                            "right": "S"
                        },
                        "weight": 1.0,
                        "padding": {
                            "top": "L",
                            "left": "M",
                            "right": "M",
                            "bottom": "L"
                        }
                    },
                    "colorScheme": "WARNING"
                },
                {
                    "text": "Positive Outlined",
                    "type": "Button",
                    "style": "OUTLINED",
                    "action": {
                        "type": "toast",
                        "message": "Positive Outlined"
                    },
                    "layout": {
                        "width": {
                            "type": "Wrap"
                        },
                        "height": {
                            "type": "Wrap"
                        },
                        "margin": {
                            "left": "S"
                        },
                        "weight": 1.0,
                        "padding": {
                            "top": "L",
                            "left": "M",
                            "right": "M",
                            "bottom": "L"
                        }
                    },
                    "colorScheme": "POSITIVE"
                }
            ]
        },
        {
            "type": "Row",
            "layout": {
                "width": {
                    "type": "Match"
                },
                "margin": {
                    "top": "L",
                    "bottom": "XL"
                }
            },
            "children": [
                {
                    "text": "Danger Text",
                    "type": "Button",
                    "style": "TEXT",
                    "action": {
                        "type": "toast",
                        "message": "Danger text"
                    },
                    "layout": {
                        "width": {
                            "type": "Wrap"
                        },
                        "height": {
                            "type": "Wrap"
                        },
                        "margin": {
                            "right": "S"
                        },
                        "weight": 1.0,
                        "padding": {
                            "top": "L",
                            "left": "M",
                            "right": "M",
                            "bottom": "L"
                        }
                    },
                    "colorScheme": "DANGER"
                },
                {
                    "text": "Warning Text",
                    "type": "Button",
                    "style": "TEXT",
                    "action": {
                        "type": "toast",
                        "message": "Warning text"
                    },
                    "layout": {
                        "width": {
                            "type": "Wrap"
                        },
                        "height": {
                            "type": "Wrap"
                        },
                        "margin": {
                            "left": "S",
                            "right": "S"
                        },
                        "weight": 1.0,
                        "padding": {
                            "top": "L",
                            "left": "M",
                            "right": "M",
                            "bottom": "L"
                        }
                    },
                    "colorScheme": "WARNING"
                },
                {
                    "text": "Positive Text",
                    "type": "Button",
                    "style": "TEXT",
                    "action": {
                        "type": "toast",
                        "message": "Positive text"
                    },
                    "layout": {
                        "width": {
                            "type": "Wrap"
                        },
                        "height": {
                            "type": "Wrap"
                        },
                        "margin": {
                            "left": "S"
                        },
                        "weight": 1.0,
                        "padding": {
                            "top": "L",
                            "left": "M",
                            "right": "M",
                            "bottom": "L"
                        }
                    },
                    "colorScheme": "POSITIVE"
                }
            ]
        },
        {
            "text": "Далее",
            "type": "Button",
            "style": "FILLED",
            "action": {
                "type": "navigate",
                "route": "#infinite-loaders"
            },
            "layout": {
                "width": {
                    "type": "Match"
                },
                "height": {
                    "type": "Wrap"
                },
                "margin": {
                    "top": "XL"
                },
                "padding": {
                    "top": "XL",
                    "left": "M",
                    "right": "M",
                    "bottom": "XL"
                }
            },
            "colorScheme": "PRIMARY"
        }
    ]
}
""".trimIndent()

val inputShowcase = """
{
    "type": "Scroll",
    "layout": {
        "width": {
            "type": "Match"
        },
        "height": {
            "type": "Match"
        },
        "padding": {
            "top": "XXL",
            "left": "XL",
            "right": "XL",
            "bottom": "XXL"
        }
    },
    "children": [
        {
            "type": "Column",
            "layout": {
                "width": {
                    "type": "Match"
                },
                "height": {
                    "type": "Wrap"
                },
                "margin": {
                    "top": "NONE",
                    "left": "NONE",
                    "right": "NONE",
                    "bottom": "NONE"
                },
                "padding": {
                    "top": "XL",
                    "left": "L",
                    "right": "L",
                    "bottom": "L"
                }
            },
            "children": [
                {
                    "text": "Проверка ввода",
                    "type": "Label",
                    "layout": {
                        "width": {
                            "type": "Match"
                        },
                        "height": {
                            "type": "Wrap"
                        },
                        "padding": {
                            "left": "L",
                            "bottom": "XXXL"
                        }
                    },
                    "typography": "H4"
                },
                {
                    "text": "Email (должен содержать @)",
                    "type": "Label",
                    "layout": {
                        "width": {
                            "type": "Match"
                        },
                        "height": {
                            "type": "Wrap"
                        },
                        "padding": {
                            "left": "L",
                            "bottom": "S"
                        }
                    },
                    "typography": "BODY1"
                },
                {
                    "hint": "email@example.com",
                    "type": "TextInput",
                    "style": "NORMAL",
                    "layout": {
                        "width": {
                            "type": "Match"
                        },
                        "height": {
                            "type": "Wrap"
                        },
                        "margin": {
                            "bottom": "L"
                        },
                        "padding": {
                            "top": "XL",
                            "left": "XL",
                            "right": "XL",
                            "bottom": "XL"
                        }
                    },
                    "typography": "BODY1",
                    "validationRegex": "^.+@.+\\..+${'$'}"
                },
                {
                    "text": "Телефон (10 цифр)",
                    "type": "Label",
                    "layout": {
                        "width": {
                            "type": "Match"
                        },
                        "height": {
                            "type": "Wrap"
                        },
                        "padding": {
                            "left": "L",
                            "bottom": "S"
                        }
                    },
                    "typography": "BODY1"
                },
                {
                    "hint": "1234567890",
                    "type": "TextInput",
                    "style": "NORMAL",
                    "layout": {
                        "width": {
                            "type": "Match"
                        },
                        "height": {
                            "type": "Wrap"
                        },
                        "margin": {
                            "bottom": "L"
                        },
                        "padding": {
                            "top": "XL",
                            "left": "XL",
                            "right": "XL",
                            "bottom": "XL"
                        }
                    },
                    "typography": "BODY1",
                    "validationRegex": "^\\d{10}${'$'}"
                },
                {
                    "text": "Пароль (не менее 6 символов)",
                    "type": "Label",
                    "layout": {
                        "width": {
                            "type": "Match"
                        },
                        "height": {
                            "type": "Wrap"
                        },
                        "padding": {
                            "left": "L",
                            "bottom": "S"
                        }
                    },
                    "typography": "BODY1"
                },
                {
                    "hint": "Введите пароль",
                    "type": "TextInput",
                    "style": "NORMAL",
                    "layout": {
                        "width": {
                            "type": "Match"
                        },
                        "height": {
                            "type": "Wrap"
                        },
                        "margin": {
                            "bottom": "XL"
                        },
                        "padding": {
                            "top": "XL",
                            "left": "XL",
                            "right": "XL",
                            "bottom": "XL"
                        }
                    },
                    "typography": "BODY1",
                    "validationRegex": "^.{6,}${'$'}"
                },
                {
                    "text": "Сумма (не менее 30000)",
                    "type": "Label",
                    "layout": {
                        "width": {
                            "type": "Match"
                        },
                        "height": {
                            "type": "Wrap"
                        },
                        "padding": {
                            "left": "L",
                            "bottom": "S"
                        }
                    },
                    "typography": "BODY1"
                },
                {
                    "hint": "Введите сумму",
                    "type": "TextInput",
                    "style": "NORMAL",
                    "layout": {
                        "width": {
                            "type": "Match"
                        },
                        "height": {
                            "type": "Wrap"
                        },
                        "margin": {
                            "bottom": "XL"
                        },
                        "padding": {
                            "top": "XL",
                            "left": "XL",
                            "right": "XL",
                            "bottom": "XL"
                        }
                    },
                    "typography": "BODY1",
                    "initialValue": "30000",
                    "validationRegex": "^(30000|[3-9]\\d{4,}|[1-9]\\d{5,})${'$'}"
                },
                {
                    "text": "Отправить",
                    "type": "Button",
                    "style": "FILLED",
                    "action": {
                        "type": "toast",
                        "message": "Отправлено!"
                    },
                    "layout": {
                        "width": {
                            "type": "Match"
                        },
                        "height": {
                            "dp": 48,
                            "type": "Fixed"
                        },
                        "padding": {
                            "top": "S",
                            "left": "S",
                            "right": "S",
                            "bottom": "S"
                        }
                    },
                    "typography": "H6",
                    "colorScheme": "PRIMARY"
                }
            ]
        }
    ],
    "orientation": "VERTICAL"
}
""".trimIndent()

val labelShowcase = """
{
    "type": "Scroll",
    "layout": {
        "width": {
            "type": "Match"
        },
        "height": {
            "type": "Match"
        },
        "padding": {
            "top": "XXL",
            "left": "XL",
            "right": "XL",
            "bottom": "XXL"
        }
    },
    "children": [
        {
            "type": "Column",
            "layout": {
                "width": {
                    "type": "Match"
                },
                "height": {
                    "type": "Wrap"
                }
            },
            "children": [
                {
                    "text": "Это стиль PRIMARY H1",
                    "type": "Label",
                    "style": "PRIMARY",
                    "layout": {
                        "margin": {
                            "top": "NONE",
                            "left": "NONE",
                            "right": "NONE",
                            "bottom": "XL"
                        },
                        "padding": {
                            "top": "XXL",
                            "left": "XL",
                            "right": "XL",
                            "bottom": "XXL"
                        }
                    },
                    "typography": "H1"
                },
                {
                    "text": "Это стиль SECONDARY H2",
                    "type": "Label",
                    "style": "SECONDARY",
                    "layout": {
                        "margin": {
                            "top": "NONE",
                            "left": "NONE",
                            "right": "NONE",
                            "bottom": "XL"
                        },
                        "padding": {
                            "top": "XXL",
                            "left": "XL",
                            "right": "XL",
                            "bottom": "XXL"
                        }
                    },
                    "typography": "H2"
                },
                {
                    "text": "Это стиль POSITIVE H3",
                    "type": "Label",
                    "style": "POSITIVE",
                    "layout": {
                        "margin": {
                            "top": "NONE",
                            "left": "NONE",
                            "right": "NONE",
                            "bottom": "XL"
                        },
                        "padding": {
                            "top": "XXL",
                            "left": "XL",
                            "right": "XL",
                            "bottom": "XXL"
                        }
                    },
                    "typography": "H3"
                },
                {
                    "text": "Это стиль WARNING H4",
                    "type": "Label",
                    "style": "WARNING",
                    "layout": {
                        "margin": {
                            "top": "NONE",
                            "left": "NONE",
                            "right": "NONE",
                            "bottom": "XL"
                        },
                        "padding": {
                            "top": "XXL",
                            "left": "XL",
                            "right": "XL",
                            "bottom": "XXL"
                        }
                    },
                    "typography": "H4"
                },
                {
                    "text": "Это стиль DANGER H5",
                    "type": "Label",
                    "style": "DANGER",
                    "layout": {
                        "margin": {
                            "top": "NONE",
                            "left": "NONE",
                            "right": "NONE",
                            "bottom": "XL"
                        },
                        "padding": {
                            "top": "XXL",
                            "left": "XL",
                            "right": "XL",
                            "bottom": "XXL"
                        }
                    },
                    "typography": "H5"
                },
                {
                    "text": "Это стиль PRIMARY H6",
                    "type": "Label",
                    "style": "PRIMARY",
                    "layout": {
                        "margin": {
                            "top": "NONE",
                            "left": "NONE",
                            "right": "NONE",
                            "bottom": "XL"
                        },
                        "padding": {
                            "top": "XXL",
                            "left": "XL",
                            "right": "XL",
                            "bottom": "XXL"
                        }
                    },
                    "typography": "H6"
                },
                {
                    "text": "Это стиль PRIMARY BODY1",
                    "type": "Label",
                    "style": "PRIMARY",
                    "layout": {
                        "margin": {
                            "top": "NONE",
                            "left": "NONE",
                            "right": "NONE",
                            "bottom": "XL"
                        },
                        "padding": {
                            "top": "XXL",
                            "left": "XL",
                            "right": "XL",
                            "bottom": "XXL"
                        }
                    },
                    "typography": "BODY1"
                },
                {
                    "text": "Это стиль PRIMARY BODY2",
                    "type": "Label",
                    "style": "PRIMARY",
                    "layout": {
                        "margin": {
                            "top": "NONE",
                            "left": "NONE",
                            "right": "NONE",
                            "bottom": "XL"
                        },
                        "padding": {
                            "top": "XXL",
                            "left": "XL",
                            "right": "XL",
                            "bottom": "XXL"
                        }
                    },
                    "typography": "BODY2"
                },
                {
                    "text": "Это стиль SECONDARY SUBTITLE1",
                    "type": "Label",
                    "style": "SECONDARY",
                    "layout": {
                        "margin": {
                            "top": "NONE",
                            "left": "NONE",
                            "right": "NONE",
                            "bottom": "XL"
                        },
                        "padding": {
                            "top": "XXL",
                            "left": "XL",
                            "right": "XL",
                            "bottom": "XXL"
                        }
                    },
                    "typography": "SUBTITLE1"
                },
                {
                    "text": "Это стиль SECONDARY SUBTITLE2",
                    "type": "Label",
                    "style": "SECONDARY",
                    "layout": {
                        "margin": {
                            "top": "NONE",
                            "left": "NONE",
                            "right": "NONE",
                            "bottom": "XL"
                        },
                        "padding": {
                            "top": "XXL",
                            "left": "XL",
                            "right": "XL",
                            "bottom": "XXL"
                        }
                    },
                    "typography": "SUBTITLE2"
                },
                {
                    "text": "Это стиль DANGER CAPTION",
                    "type": "Label",
                    "style": "DANGER",
                    "layout": {
                        "margin": {
                            "top": "NONE",
                            "left": "NONE",
                            "right": "NONE",
                            "bottom": "XL"
                        },
                        "padding": {
                            "top": "XXL",
                            "left": "XL",
                            "right": "XL",
                            "bottom": "XXL"
                        }
                    },
                    "typography": "CAPTION"
                }
            ]
        }
    ],
    "orientation": "VERTICAL"
}
""".trimIndent()

val iconShowcase = """
{
    "type": "Scroll",
    "layout": {
        "width": {
            "type": "Match"
        },
        "height": {
            "type": "Match"
        },
        "padding": {
            "top": "M",
            "left": "M",
            "right": "M",
            "bottom": "M"
        }
    },
    "children": [
        {
            "type": "Scroll",
            "layout": {
                "width": {
                    "type": "Match"
                },
                "height": {
                    "type": "Wrap"
                }
            },
            "children": [
                {
                    "type": "Column",
                    "layout": {
                        "width": {
                            "type": "Wrap"
                        },
                        "height": {
                            "type": "Wrap"
                        }
                    },
                    "children": [
                        {
                            "type": "Row",
                            "layout": {
                                "width": {
                                    "type": "Wrap"
                                },
                                "height": {
                                    "type": "Wrap"
                                },
                                "margin": {
                                    "bottom": "S"
                                }
                            },
                            "children": [
                                {
                                    "name": "ic_arrow_back",
                                    "size": "XXL",
                                    "type": "Icon"
                                },
                                {
                                    "name": "ic_alert",
                                    "size": "XXL",
                                    "type": "Icon"
                                },
                                {
                                    "name": "ic_award",
                                    "size": "XXL",
                                    "type": "Icon"
                                },
                                {
                                    "name": "ic_airplay",
                                    "size": "XXL",
                                    "type": "Icon"
                                }
                            ]
                        },
                        {
                            "type": "Row",
                            "layout": {
                                "width": {
                                    "type": "Wrap"
                                },
                                "height": {
                                    "type": "Wrap"
                                },
                                "margin": {
                                    "bottom": "S"
                                }
                            },
                            "children": [
                                {
                                    "name": "ic_bell_off",
                                    "size": "XXL",
                                    "type": "Icon"
                                },
                                {
                                    "name": "ic_activity",
                                    "size": "XXL",
                                    "type": "Icon"
                                },
                                {
                                    "name": "ic_bell",
                                    "size": "XXL",
                                    "type": "Icon"
                                },
                                {
                                    "name": "ic_aperture",
                                    "size": "XXL",
                                    "type": "Icon"
                                }
                            ]
                        },
                        {
                            "type": "Row",
                            "layout": {
                                "width": {
                                    "type": "Wrap"
                                },
                                "height": {
                                    "type": "Wrap"
                                },
                                "margin": {
                                    "bottom": "S"
                                }
                            },
                            "children": [
                                {
                                    "name": "ic_bookmark",
                                    "size": "XXL",
                                    "type": "Icon"
                                },
                                {
                                    "name": "ic_box",
                                    "size": "XXL",
                                    "type": "Icon"
                                },
                                {
                                    "name": "ic_camera",
                                    "size": "XXL",
                                    "type": "Icon"
                                },
                                {
                                    "name": "ic_check",
                                    "size": "XXL",
                                    "type": "Icon"
                                }
                            ]
                        },
                        {
                            "type": "Row",
                            "layout": {
                                "width": {
                                    "type": "Wrap"
                                },
                                "height": {
                                    "type": "Wrap"
                                }
                            },
                            "children": [
                                {
                                    "name": "ic_clock",
                                    "size": "XXL",
                                    "type": "Icon"
                                },
                                {
                                    "name": "ic_coffee",
                                    "size": "XXL",
                                    "type": "Icon"
                                },
                                {
                                    "name": "ic_dollar",
                                    "size": "XXL",
                                    "type": "Icon"
                                },
                                {
                                    "name": "ic_download",
                                    "size": "XXL",
                                    "type": "Icon"
                                }
                            ]
                        },
                        {
                            "type": "Row",
                            "layout": {
                                "width": {
                                    "type": "Wrap"
                                },
                                "height": {
                                    "type": "Wrap"
                                }
                            },
                            "children": [
                                {
                                    "name": "ic_eye",
                                    "size": "XXL",
                                    "type": "Icon"
                                },
                                {
                                    "name": "ic_heart",
                                    "size": "XXL",
                                    "type": "Icon"
                                },
                                {
                                    "name": "ic_gift",
                                    "size": "XXL",
                                    "type": "Icon"
                                },
                                {
                                    "name": "ic_info",
                                    "size": "XXL",
                                    "type": "Icon"
                                }
                            ]
                        },
                        {
                            "type": "Row",
                            "layout": {
                                "width": {
                                    "type": "Wrap"
                                },
                                "height": {
                                    "type": "Wrap"
                                }
                            },
                            "children": [
                                {
                                    "name": "ic_home",
                                    "size": "XXL",
                                    "type": "Icon"
                                },
                                {
                                    "name": "ic_link",
                                    "size": "XXL",
                                    "type": "Icon"
                                },
                                {
                                    "name": "ic_lock",
                                    "size": "XXL",
                                    "type": "Icon"
                                },
                                {
                                    "name": "ic_mail",
                                    "size": "XXL",
                                    "type": "Icon"
                                }
                            ]
                        }
                    ]
                }
            ],
            "orientation": "HORIZONTAL"
        }
    ],
    "orientation": "VERTICAL"
}
""".trimIndent()

val sliderShowcase = """
{
    "type": "Scroll",
    "layout": {
        "width": {
            "type": "Match"
        },
        "height": {
            "type": "Match"
        },
        "padding": {
            "top": "XXL",
            "left": "XL",
            "right": "XL",
            "bottom": "XXL"
        }
    },
    "children": [
        {
            "type": "Column",
            "layout": {
                "width": {
                    "type": "Match"
                },
                "height": {
                    "type": "Wrap"
                },
                "margin": {
                    "top": "NONE",
                    "left": "NONE",
                    "right": "NONE",
                    "bottom": "NONE"
                }
            },
            "children": [
                {
                    "max": 100,
                    "min": 0,
                    "type": "Slider",
                    "style": "FILLED",
                    "value": 25,
                    "layout": {
                        "width": {
                            "type": "Match"
                        },
                        "height": {
                            "type": "Wrap"
                        },
                        "margin": {
                            "top": "XXL",
                            "bottom": "XXL"
                        }
                    }
                },
                {
                    "max": 100,
                    "min": 0,
                    "type": "Slider",
                    "style": "OUTLINED",
                    "value": 50,
                    "layout": {
                        "width": {
                            "type": "Match"
                        },
                        "height": {
                            "type": "Wrap"
                        },
                        "margin": {
                            "top": "XXL",
                            "bottom": "XXL"
                        }
                    }
                },
                {
                    "max": 100,
                    "min": 0,
                    "type": "Slider",
                    "style": "GHOST",
                    "value": 75,
                    "layout": {
                        "width": {
                            "type": "Match"
                        },
                        "height": {
                            "type": "Wrap"
                        },
                        "margin": {
                            "top": "XXL",
                            "bottom": "XXL"
                        }
                    }
                },
                {
                    "max": 50000,
                    "min": 1000,
                    "step": 5,
                    "type": "Slider",
                    "style": "FILLED",
                    "value": 25500,
                    "layout": {
                        "width": {
                            "type": "Match"
                        },
                        "height": {
                            "type": "Wrap"
                        },
                        "margin": {
                            "top": "XXL",
                            "bottom": "XXL"
                        }
                    }
                }
            ]
        }
    ],
    "orientation": "VERTICAL"
}
""".trimIndent()

val testSample = """
{
    "type": "Scroll",
    "layout": {
        "width": {
            "type": "Match"
        },
        "height": {
            "type": "Match"
        },
        "padding": {
            "top": "L",
            "left": "M",
            "right": "M",
            "bottom": "L"
        }
    },
    "children": [
        {
            "type": "Column",
            "layout": {
                "width": {
                    "type": "Match"
                },
                "height": {
                    "type": "Wrap"
                },
                "margin": {
                    "top": "NONE",
                    "left": "NONE",
                    "right": "NONE",
                    "bottom": "NONE"
                }
            },
            "children": [
                {
                    "type": "Scroll",
                    "layout": {
                        "width": {
                            "type": "Match"
                        },
                        "height": {
                            "type": "Wrap"
                        },
                        "margin": {
                            "top": "S",
                            "bottom": "L"
                        }
                    },
                    "children": [
                        {
                            "type": "Row",
                            "layout": {
                                "width": {
                                    "type": "Wrap"
                                },
                                "height": {
                                    "type": "Wrap"
                                }
                            },
                            "children": [
                                {
                                    "text": "Кнопка 1",
                                    "type": "Button",
                                    "style": "FILLED",
                                    "action": {
                                        "type": "toast",
                                        "message": "Нажата 1"
                                    },
                                    "layout": {
                                        "width": {
                                            "type": "Wrap"
                                        },
                                        "height": {
                                            "type": "Wrap"
                                        },
                                        "margin": {
                                            "right": "S"
                                        },
                                        "padding": {
                                            "top": "M",
                                            "left": "M",
                                            "right": "M",
                                            "bottom": "M"
                                        }
                                    },
                                    "typography": "H2"
                                },
                                {
                                    "text": "Кнопка 2",
                                    "type": "Button",
                                    "style": "FILLED",
                                    "action": {
                                        "type": "toast",
                                        "message": "Нажата 2"
                                    },
                                    "layout": {
                                        "width": {
                                            "type": "Wrap"
                                        },
                                        "height": {
                                            "type": "Wrap"
                                        },
                                        "margin": {
                                            "right": "S"
                                        },
                                        "padding": {
                                            "top": "M",
                                            "left": "M",
                                            "right": "M",
                                            "bottom": "M"
                                        }
                                    },
                                    "typography": "H2"
                                },
                                {
                                    "text": "Кнопка 3",
                                    "type": "Button",
                                    "style": "FILLED",
                                    "action": {
                                        "type": "toast",
                                        "message": "Нажата 3"
                                    },
                                    "layout": {
                                        "width": {
                                            "type": "Wrap"
                                        },
                                        "height": {
                                            "type": "Wrap"
                                        },
                                        "padding": {
                                            "top": "M",
                                            "left": "M",
                                            "right": "M",
                                            "bottom": "M"
                                        }
                                    },
                                    "typography": "H2"
                                }
                            ]
                        }
                    ],
                    "orientation": "HORIZONTAL"
                },
                {
                    "type": "Scroll",
                    "layout": {
                        "width": {
                            "type": "Match"
                        },
                        "height": {
                            "type": "Wrap"
                        },
                        "margin": {
                            "top": "S",
                            "bottom": "L"
                        }
                    },
                    "children": [
                        {
                            "type": "Row",
                            "layout": {
                                "width": {
                                    "type": "Wrap"
                                },
                                "height": {
                                    "type": "Wrap"
                                }
                            },
                            "children": [
                                {
                                    "text": "Выбор A",
                                    "type": "Button",
                                    "style": "OUTLINED",
                                    "action": {
                                        "type": "toast",
                                        "message": "Выбор A"
                                    },
                                    "layout": {
                                        "width": {
                                            "type": "Wrap"
                                        },
                                        "height": {
                                            "type": "Wrap"
                                        },
                                        "margin": {
                                            "right": "S"
                                        },
                                        "padding": {
                                            "top": "M",
                                            "left": "M",
                                            "right": "M",
                                            "bottom": "M"
                                        }
                                    },
                                    "typography": "H2"
                                },
                                {
                                    "text": "Выбор B",
                                    "type": "Button",
                                    "style": "OUTLINED",
                                    "action": {
                                        "type": "toast",
                                        "message": "Выбор B"
                                    },
                                    "layout": {
                                        "width": {
                                            "type": "Wrap"
                                        },
                                        "height": {
                                            "type": "Wrap"
                                        },
                                        "margin": {
                                            "right": "S"
                                        },
                                        "padding": {
                                            "top": "M",
                                            "left": "M",
                                            "right": "M",
                                            "bottom": "M"
                                        }
                                    },
                                    "typography": "H2"
                                },
                                {
                                    "text": "Выбор C",
                                    "type": "Button",
                                    "style": "OUTLINED",
                                    "action": {
                                        "type": "toast",
                                        "message": "Выбор C"
                                    },
                                    "layout": {
                                        "width": {
                                            "type": "Wrap"
                                        },
                                        "height": {
                                            "type": "Wrap"
                                        },
                                        "padding": {
                                            "top": "M",
                                            "left": "M",
                                            "right": "M",
                                            "bottom": "M"
                                        }
                                    },
                                    "typography": "H2"
                                }
                            ]
                        }
                    ],
                    "orientation": "HORIZONTAL"
                },
                {
                    "max": 100,
                    "min": 0,
                    "step": 5,
                    "type": "Slider",
                    "style": "FILLED",
                    "value": 40,
                    "layout": {
                        "width": {
                            "type": "Match"
                        },
                        "height": {
                            "type": "Wrap"
                        },
                        "margin": {
                            "top": "XXL",
                            "bottom": "XXL"
                        }
                    }
                }
            ]
        }
    ],
    "orientation": "VERTICAL"
}
""".trimIndent()
