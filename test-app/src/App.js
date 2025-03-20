import React, { useEffect, useState } from "react";

function App() {
  const [users, setUsers] = useState([]);

  useEffect(() => {
    // Запрос к полному URL (без прокси):
    fetch("http://localhost:8080/api/users")
      .then(response => {
        if (!response.ok) {
          throw new Error(`HTTP error! status: ${response.status}`);
        }
        return response.json();
      })
      .then(data => {
        console.log("Users:", data);
        setUsers(data);
      })
      .catch(error => {
        console.error("Ошибка при запросе:", error);
      });
  }, []);

  return (
    <div>
      <h1>Users</h1>
      <ul>
        {users.map(u => (
          <li key={u.id}>{u.username}</li>
        ))}
      </ul>
    </div>
  );
}

export default App;
