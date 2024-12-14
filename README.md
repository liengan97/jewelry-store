# User Service API endpoint
## Register
POST <code>/users<code>

For example:
```sh
curl POST 'http://localhost:8080/users/register'

```
Request Body
```shell
{
    "name": "User 1",
    "email": "user1@gmail.com",
    "password": "12345p1",
    "phone": "0908364647"
}
```
Response Body
```shell
{
    "id": "25ba7791-9458-4081-8c52-acb5ce9fd957",
    "name": "User 1",
    "email": "user1@gmail.com",
    "password": "12345p1",
    "phone": "0908364647",
    "role": "null"
}
```

## Get all users
GET <code>/users</code>

For example:
```sh
curl GET 'http://localhost:8080/users'
```
Response Body
```
[
    {
        "id": "d7418063-dd45-46f5-9aab-e7a674b32757",
        "name": "User 2",
        "email": "user2@gmail.com",
        "password": "23434",
        "phone": null,
        "role": "ADMIN"
    },
    {
        "id": "130707a3-da4a-4fdc-bf27-9c463ef2977e",
        "name": "User",
        "email": "user@gmail.com",
        "password": "23user434",
        "phone": null,
        "role": "null"
    },
    {
        "id": "bc4face6-1446-42c1-a1c0-3120e93bb6de",
        "name": "t",
        "email": "t@gmail.com",
        "password": "e26",
        "phone": null,
        "role": "null"
    },
    {
        "id": "25ba7791-9458-4081-8c52-acb5ce9fd957",
        "name": "User 1",
        "email": "user1@gmail.com",
        "password": "12345p1",
        "phone": null,
        "role": "null"
    },
    {
        "id": "a79f6483-9fb6-4d15-88e4-4bc4c2bd7167",
        "name": "Testsd",
        "email": "tesr1@gmail.com",
        "password": "e26",
        "phone": null,
        "role": "null"
    }
]
```

## Get user by <code> id </code>
GET <code>/users/{id}</code>

For example:
```sh
curl GET 'http://localhost:8080/users/130707a3-da4a-4fdc-bf27-9c463ef2977e'
```
Response Body
```
{
    "id": "130707a3-da4a-4fdc-bf27-9c463ef2977e",
    "name": "User",
    "email": "user@gmail.com",
    "password": "23user434",
    "phone": "0909090434",
    "role": "null"
}
```

## Search users by <code> name </code>
GET <code>/customers/search?name={keyword}</code>

For example:
```sh
curl GET 'http://localhost:8080/users/search?name=us'
```

Response Body
```
[
    {
        "id": "25ba7791-9458-4081-8c52-acb5ce9fd957",
        "name": "User 1",
        "email": "user1@gmail.com",
        "password": "12345p1",
        "phone": null,
        "role": "null"
    },
    {
        "id": "130707a3-da4a-4fdc-bf27-9c463ef2977e",
        "name": "User",
        "email": "user@gmail.com",
        "password": "23user434",
        "phone": null,
        "role": "null"
    },
    {
        "id": "d7418063-dd45-46f5-9aab-e7a674b32757",
        "name": "User 2",
        "email": "user2@gmail.com",
        "password": "23434",
        "phone": null,
        "role": "ADMIN"
    }
]
```

## Delete users by <code> id </code>
DELETE <code>users/delete?id={id}</code>

For Example:
```shell
curl DELETE 'http://localhost:8080/users/delete?id=bc4face6-1446-42c1-a1c0-3120e93bb6de'
```
Response Body
```
true
```

