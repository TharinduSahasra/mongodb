import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { useParams, useNavigate } from 'react-router-dom';

const EditStudent = () => {
  const { id } = useParams<{ id: string }>();
  const [student, setStudent] = useState<any>({
    firstName: '',
    lastName: '',
    email: '',
    department: 'Computer Science',
    yearsOfEnrollment: 1,
  });
  const navigate = useNavigate();

  useEffect(() => {
    const fetchStudent = async () => {
      try {
        const response = await axios.get(`http://localhost:8080/api/student/getStudentById/${id}`);
        setStudent(response.data);
      } catch (err) {
        console.error(err);
      }
    };
    fetchStudent();
  }, [id]);

  const handleChange = (e: React.ChangeEvent<HTMLInputElement | HTMLSelectElement>) => {
    const { name, value } = e.target;
    setStudent({ ...student, [name]: value });
  };

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    try {
      await axios.put(`http://localhost:8080/api/student/updateStudent/${id}`, student);
      navigate('/');
    } catch (err) {
      console.error(err);
      alert('Error updating student');
    }
  };

  return (
    <div>
      <h2>Edit Student</h2>
      <form onSubmit={handleSubmit}>
        <input
          type="text"
          name="firstName"
          value={student.firstName}
          onChange={handleChange}
          required
        />
        <input
          type="text"
          name="lastName"
          value={student.lastName}
          onChange={handleChange}
          required
        />
        <input
          type="email"
          name="email"
          value={student.email}
          onChange={handleChange}
          required
        />
        <select
          name="department"
          value={student.department}
          onChange={handleChange}
        >
          <option value="Computer Science">Computer Science</option>
          <option value="Statistics">Statistics</option>
          <option value="Mathametics">Mathamatics</option>
          <option value="Physics">Physics</option>
          <option value="Chemistry">Chemistry</option>  
          <option value="Biology">Biology</option>
          <option value="Geology">Geology</option>
        </select>
        <input
          type="number"
          name="yearsOfEnrollment"
          value={student.yearsOfEnrollment}
          onChange={handleChange}
          required
        />
        <button type="submit">Update Student</button>
      </form>
      <button onClick={() => navigate('/')}>Back to Student List</button>
    </div>
  );
};

export default EditStudent;
