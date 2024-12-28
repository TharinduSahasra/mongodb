import { useEffect, useState } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';

const StudentList = () => {
  const [students, setStudents] = useState<any[]>([]);

  useEffect(() => {
    const fetchStudents = async () => {
      try {
        const response = await axios.get('http://localhost:8080/api/student/getAllStudents');
        setStudents(response.data);
      } catch (err) {
        console.error(err);
      }
    };
    fetchStudents();
  }, []);

  const handleDelete = async (id: string) => {
    try {
      await axios.delete(`http://localhost:8080/api/student/deleteStudent/${id}`);
      setStudents(students.filter(student => student.id !== id));
    } catch (err) {
      console.error(err);
    }
  };

  return (
    <div>
      <h2>Student List</h2>
      <table border={1}>
        <thead>
          <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
            <th>Department</th>
            <th>Years of Enrollment</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {students.map((student) => (
            <tr key={student.id}>
              <td>{student.firstName}</td>
              <td>{student.lastName}</td>
              <td>{student.email}</td>
              <td>{student.department}</td>
              <td>{student.yearsOfEnrollment}</td>
              <td>
                <Link to={`/edit/${student.id}`}>Edit</Link> | 
                <button  onClick={() => handleDelete(student.id)} style={{ backgroundColor: 'red', color: 'white', border: 'none', padding: '5px 10px', cursor: 'pointer' }}>Delete</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
      <Link to="/add">Add New Student</Link>
    </div>
  );
};

export default StudentList;
