package org.family.pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


/**
 * 系统角色实体类;
 * @author DanteFung
 * @version v.0.1
 */
@Entity
public class SysRole implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name="seq_sys_role_generator",sequenceName="seq_sys_role",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq_sys_role_generator")
	private Long id; // 编号
	private String role; // 角色标识 程序中判断使用,如"admin",这个是唯一的:
	private String description; // 角色描述,UI界面显示使用
	private String available = "N"; // 是否可用,如果不可用将不会添加给用户
	
	//角色 -- 权限关系： 多对多关系;
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="SysRolePermission",joinColumns={@JoinColumn(name="roleId")},inverseJoinColumns={@JoinColumn(name="permissionId")})
	private List<SysPermission> permissions;
	
	// 用户 - 角色关系定义;
	@ManyToMany
	@JoinTable(name="SysUserRole",joinColumns={@JoinColumn(name="roleId")},inverseJoinColumns={@JoinColumn(name="userId")})
	private List<UserInfo> userInfos;// 一个角色对应多个用户
	
	public List<UserInfo> getUserInfos() {
		return userInfos;
	}
	public void setUserInfos(List<UserInfo> userInfos) {
		this.userInfos = userInfos;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getAvailable() {
		return available;
	}

	public void setAvailable(String available) {
		this.available = available;
	}

	public List<SysPermission> getPermissions() {
		return permissions;
	}
	public void setPermissions(List<SysPermission> permissions) {
		this.permissions = permissions;
	}

	@Override
	public String toString() {
		return "SysRole{" +
				"id=" + id +
				", role='" + role + '\'' +
				", description='" + description + '\'' +
				", available='" + available + '\'' +
				", permissions=" + permissions +
				", userInfos=" + userInfos +
				'}';
	}
}
