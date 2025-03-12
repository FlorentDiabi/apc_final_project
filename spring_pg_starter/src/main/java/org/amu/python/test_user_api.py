import requests
import json

BASE_URL = "http://localhost:8080"

# Test GET /users
def test_get_all_users():
    response = requests.get(f"{BASE_URL}/users")
    if response.status_code == 200:
        print("Test GET /users: Success")
        print(json.dumps(response.json(), indent=2))
    else:
        print(f"Test GET /users failed with status code {response.status_code}")

# Test GET /users/get/{id}
def test_get_user_by_id(user_id):
    response = requests.get(f"{BASE_URL}/users/get/{user_id}")
    if response.status_code == 200:
        print(f"Test GET /users/get/{user_id}: Success")
        print(json.dumps(response.json(), indent=2))
    else:
        print(f"Test GET /users/get/{user_id} failed with status code {response.status_code}")

# Test POST /users/new
def test_create_user():
    user_data = {
        "active": True,
        "email": "john.doe@example.com",
        "firstName": "John",
        "lastName": "Doe",
        "password": "securePassword123",
        "role": "STUDENT",
        "username": "johndoe"
    }
    response = requests.post(f"{BASE_URL}/users/new", json=user_data)
    if response.status_code == 201:
        print("Test POST /users/new: Success")
        print(json.dumps(response.json(), indent=2))
    else:
        print(f"Test POST /users/new failed with status code {response.status_code}")

# Test PUT /users/update/{id}
def test_update_user(user_id):
    updated_user_data = {
        "active": True,
        "email": "john.doe.new@example.com",
        "firstName": "John",
        "lastName": "Doe",
        "password": "newSecurePassword123",
        "role": "TEACHER",
        "username": "johnnydoe"
    }
    response = requests.put(f"{BASE_URL}/users/update/{user_id}", json=updated_user_data)
    if response.status_code == 200:
        print(f"Test PUT /users/update/{user_id}: Success")
        print(json.dumps(response.json(), indent=2))
    else:
        print(f"Test PUT /users/update/{user_id} failed with status code {response.status_code}")

# Test DELETE /users/delete/{id}
def test_delete_user(user_id):
    response = requests.delete(f"{BASE_URL}/users/delete/{user_id}")
    if response.status_code == 200:
        print(f"Test DELETE /users/delete/{user_id}: Success")
    else:
        print(f"Test DELETE /users/delete/{user_id} failed with status code {response.status_code}")

if __name__ == "__main__":
    # Teste chaque méthode
    test_get_all_users()
    test_get_user_by_id(1)
    test_create_user()
    test_update_user(1)
    test_delete_user(1)
