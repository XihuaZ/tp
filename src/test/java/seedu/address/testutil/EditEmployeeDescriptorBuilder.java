package seedu.address.testutil;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import seedu.address.logic.commands.EditCommand;
import seedu.address.model.department.Department;
import seedu.address.model.employee.Address;
import seedu.address.model.employee.Email;
import seedu.address.model.employee.Employee;
import seedu.address.model.employee.Name;
import seedu.address.model.employee.Phone;
import seedu.address.model.employee.Salary;

/**
 * A utility class to help with building EditEmployeeDescriptor objects.
 */
public class EditEmployeeDescriptorBuilder {

    private EditCommand.EditEmployeeDescriptor descriptor;

    public EditEmployeeDescriptorBuilder() {
        descriptor = new EditCommand.EditEmployeeDescriptor();
    }

    public EditEmployeeDescriptorBuilder(EditCommand.EditEmployeeDescriptor descriptor) {
        this.descriptor = new EditCommand.EditEmployeeDescriptor(descriptor);
    }

    /**
     * Returns an {@code EditEmployeeDescriptor} with fields containing {@code employee}'s details
     */
    public EditEmployeeDescriptorBuilder(Employee employee) {
        descriptor = new EditCommand.EditEmployeeDescriptor();
        descriptor.setName(employee.getName());
        descriptor.setPhone(employee.getPhone());
        descriptor.setEmail(employee.getEmail());
        descriptor.setAddress(employee.getAddress());
        descriptor.setSalary(employee.getSalary());
        descriptor.setDepartments(employee.getDepartments());
    }

    /**
     * Sets the {@code Name} of the {@code EditEmployeeDescriptor} that we are building.
     */
    public EditEmployeeDescriptorBuilder withName(String name) {
        descriptor.setName(new Name(name));
        return this;
    }

    /**
     * Sets the {@code Phone} of the {@code EditEmployeeDescriptor} that we are building.
     */
    public EditEmployeeDescriptorBuilder withPhone(String phone) {
        descriptor.setPhone(new Phone(phone));
        return this;
    }

    /**
     * Sets the {@code Email} of the {@code EditEmployeeDescriptor} that we are building.
     */
    public EditEmployeeDescriptorBuilder withEmail(String email) {
        descriptor.setEmail(new Email(email));
        return this;
    }

    /**
     * Sets the {@code Address} of the {@code EditEmployeeDescriptor} that we are building.
     */
    public EditEmployeeDescriptorBuilder withAddress(String address) {
        descriptor.setAddress(new Address(address));
        return this;
    }

    /**
     * Sets the {@code Salary} of the {@code EditEmployeeDescriptor} that we are building.
     */
    public EditEmployeeDescriptorBuilder withSalary(String salary) {
        descriptor.setSalary(new Salary(salary));
        return this;
    }

    /**
     * Parses the {@code departments} into a {@code Set<Department>} and set it to the {@code EditEmployeeDescriptor}
     * that we are building.
     */
    public EditEmployeeDescriptorBuilder withDepartments(String... departments) {
        Set<Department> departmentSet = Stream.of(departments).map(Department::new).collect(Collectors.toSet());
        descriptor.setDepartments(departmentSet);
        return this;
    }

    public EditCommand.EditEmployeeDescriptor build() {
        return descriptor;
    }
}
