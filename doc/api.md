# wonderWall API

<!-- MarkdownTOC -->

- [返回状态说明](#返回状态说明)
- [电影信息类](#电影信息类)
    - [获取热映电影](#获取热映电影)
    - [获取所有电影](#获取所有电影)
    - [获取电影详细信息](#获取电影详细信息)
    - [获取上映该电影的影院](#获取上映该电影的影院)
    - [获取上映该电影的影院的所有厅](#获取上映该电影的影院的所有厅)
    - [获取厅次的所有座位](#获取厅次的所有座位)
- [购买电影票类](#购买电影票类)
    - [购买电影票](#购买电影票)
- [用户管理类](#用户管理类)
    - [用户登录](#用户登录)
    - [用户登出](#用户登出)
    - [用户注册](#用户注册)


<!-- /MarkdownTOC -->

<a name="返回状态说明"></a>
## 返回状态说明

一个请求是否成功是由 HTTP 状态码标明的。一个 2XX 的状态码表示成功，而一个 4XX 表示请求失败。当一个请求失败时响应的主体仍然是一个 JSON 对象，里面包含 `status` 和 `errorText` 这两个字段，分别表示 wonderWall 自定义的错误码以及错误信息，便于调试。


<a name="错误信息"></a>
### 错误信息

`errorText` 列表示服务端源码中的

| errorText | HTTP Status | Description |
|:----:|:-----------:|-------------|
|用户名或密码错误|404|用户名或密码错误|
|用户未登录|401|用户未登录|
|用户名已存在|403|用户名已存在|
|用户不存在|400|用户不存在|



<a name="电影信息类"></a>
## 电影信息类

<a name="获取热映电影"></a>
### 获取热映电影

Request URI:

```
GET /api/hotMovies
```

Response Properties:

| 参数名称 | 是否必须 | 数据类型 |
|----------|-------------|------|
|count|true|number|
|start|true|number|
|total|true|number|
|subjects|true|array[object]|
|rating|true|object|
|max|true|numbe|
|average|true|number|
|stars|true|string|
|min|true|number|
|genres|true|array[string]|
|title|true|string|
|casts|true|array|
|collect_count|true|number|
|original_title|true|string|
|subtype|true|string|
|directors|true|array[object]|
|alt|true|string|
|avatars|true|object|
|small|true|string|
|large|true|string|
|medium|true|string|
|name|true|string|
|id|true|string|
|year|true|string|
|images|true|object|
|small|true|string|
|large|true|string|
|medium|true|string|
|alt|true|string|
|id|true|string|
|title|true|string|

Response Example:

```json
{
    "count": 63,
    "start": 76,
    "total": 75,
    "subjects": [
        {
            "rating": {
                "max": 96,
                "average": 87,
                "stars": "mock",
                "min": 93
            },
            "genres": [
                "1",
                "2",
                "3",
                "4",
                "5"
            ],
            "title": "mock",
            "casts": [ ],
            "collect_count": 17,
            "original_title": "mock",
            "subtype": "mock",
            "directors": [
                {
                    "alt": "mock",
                    "avatars": {
                        "small": "mock",
                        "large": "mock",
                        "medium": "mock"
                    },
                    "name": "mock",
                    "id": "mock"
                }
            ],
            "year": "mock",
            "images": {
                "small": "mock",
                "large": "mock",
                "medium": "mock"
            },
            "alt": "mock",
            "id": "mock"
        }
    ],
    "title": "mock"
}

```

<a name="获取所有电影"></a>
### 获取所有电影

Request URI:

```
GET /api/movies
```

Response Properties:

同获取热映电影

Response Example:

同获取热映电影

<a name="获取电影详细信息"></a>
### 获取电影详细信息

Request URI:

```
GET /api/movies/{movieId}
```

Response Properties:

同获取热映电影

Response Example:

同获取热映电影

<a name="获取上映该电影的影院"></a>
### 获取上映该电影的影院

Request URI:

```
GET /api/movies/{movieId}/cinema
```

Request Parameters:

| 参数名称 | 描述 | 数据类型 |
|-------|-------------|------|
|movieId|电影的id|int|

Response Properties:

|参数名称|是否必须|数据类型|
|----------|-------------|------|
|id|true|number|
|name|true|string|
|address|true|string|

Response Example:

```json
{
    "id": 33,
    "name": "mock",
    "address": "mock"
}

```

<a name="获取上映该电影的影院的所有厅"></a>
### 获取上映该电影的影院的所有厅

Request URI:

```
GET /api/movies/{movieId}/cinema/{cinemaId}
```

Request Parameters:

| 参数名称 | 描述 | 数据类型 |
|-------|-------------|------|
|movieId|电影的id|int|
|cinemaId|电影的id|int|

Response Properties:

|参数名称|是否必须|数据类型|
|----------|-------------|------|
|id|true|number|
|name|true|string|

Response Example:

```json
{
    "id": 32,
    "number": 86
}

```

<a name="获取厅次的所有座位"></a>
### 获取厅次的所有座位

Request URI:

```
GET /api/movies/{movieId}/cinema/{cinemaId}/hall/{hallId}
```

Request Parameters:

| 参数名称 | 描述 | 数据类型 |
|-------|-------------|------|
|movieId|电影的id|int|
|cinemaId|电影的id|int|
|hallId|电影厅的id|int|

Response Properties:

|参数名称|是否必须|数据类型|
|----------|-------------|------|
|id|true|number|
|positionX|true|number|
|positionY|true|number|
|sold|true|boolean|

Response Example:

```json
{
    "id": 76,
    "positionX": 1,
    "positionY": 72,
    "sold": true
}

```

<a name="购买电影票类"></a>
## 购买电影票类

<a name="购买电影票"></a>
### 购买电影票

Request URI:

```
GET /api/movies/{movieId}/cinema/{cinemaId}/hall
```

Request Parameters:

| 参数名称 | 描述 | 数据类型 |
|-------|-------------|------|
|movieId|电影的id|int|
|cinemaId|电影的id|int|
|hallId|电影厅的id|int|
|seats|选定的座位|array[object]|
|orderDate|购买的日期|string|
|ticketPrice|票价|double|

Response Properties:

|参数名称|是否必须|数据类型|
|----------|-------------|------|
|id|true|number|
|user|true|object|
|orderDate|true|string|
|ticketPrice|true|number|
|ticketCount|true|number|
|seats|true|array[object]|


Response Example:

```json
{
    "id": 1,
    "user": {
        "username": "mock",
        "gender": 42
    },
    "orderDate": "mock",
    "ticketPrice": 55,
    "ticketCount": 30,
    "seats": [
        {
            "id": 1,
            "positionX": 83,
            "positionY": 5,
            "sold": true
        }
    ]
}

```

<a name="用户管理类"></a>
## 用户管理类

<a name="用户登录"></a>
### 用户登录

Request URI:

```
GET /api/login
```

Request Parameters:

| 参数名称 | 描述 | 数据类型 |
|-------|-------------|------|
|username|用户名|string|
|password|密码|string|



<a name="用户登出"></a>
### 用户登出

Request URI:

```
GET /api/logout
```

<a name="用户注册"></a>
### 用户注册

Request URI:

```
GET /api/signup
```

Request Parameters:

| 参数名称 | 描述 | 数据类型 |
|-------|-------------|------|
|username|用户名|string|
|password|密码|string|
