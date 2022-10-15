@GetMapping(value="/search", produces = "application/json")
	public List<Property> getPropertiesBySearch(@RequestBody PropertyRequest propertyRequest) {
		String queryString = "select * from Property where 1=1";
		queryString = checkForTheSearchField(queryString, propertyRequest);
		Query query = entityManager.createNativeQuery(queryString);
		List<Object[]> propertyList = query.getResultList();
		return formResponseObject(propertyList);
	}

	private List<Property> formResponseObject(List<Object[]> propertyList) {
		//0:propertyID, 1:pty_name, 2:pty_town, 3:pty_city, 4:pty_state, 5:pty_category, 6:pty_type,
		//7:pty_price, 8:pty_status, 9:pty_owner, 10:pty_unique, 11:pty_area, 12:pty_bed, 13:pty_country, 14:pty_zipcode, 15:pty_available_date, 16:pty_owner_id
		List<Property> responseObject = new ArrayList();
		for(int k=0;k<propertyList.size();k++) {
				Object[] pList = propertyList.get(k);
				Property response = new Property();
				
				response.setPropertyId(Integer.valueOf(safeConvertToString(pList[0])));
				response.setPropertyName(safeConvertToString(pList[1]));
				response.setPropertyTown(safeConvertToString(pList[2]));
				response.setPropertyCity(safeConvertToString(pList[3]));
				response.setPropertyState(safeConvertToString(pList[4]));
				response.setPropertyCategory(safeConvertToString(pList[5]));
				
				response.setPropertyType(safeConvertToString(pList[6]));
				response.setPropertyPrice(Float.parseFloat(safeConvertToString(pList[7])));
				response.setPropertyStatus(safeConvertToString(pList[8]));
				response.setPropertyOwner(safeConvertToString(pList[9]));
				response.setPropertyUniqueId(safeConvertToString(pList[10]));
				
				response.setPropertyArea(Integer.valueOf(safeConvertToString(pList[11])));
				response.setPropertyBed(Integer.valueOf(safeConvertToString(pList[12])));
				response.setPropertyCountry(safeConvertToString(pList[13]));
				response.setPropertyZipCode(Integer.valueOf(safeConvertToString(pList[14])));
				response.setPropertyAvailableDate((java.sql.Date) pList[15]);
				response.setPropertyOwnerId(Integer.valueOf(safeConvertToString(pList[16])));
				
				responseObject.add(response);
			
		}
		return responseObject;	
	}

	private static String safeConvertToString(Object obj) {
		return null != obj ? obj.toString() : null;
	}

	private String checkForTheSearchField(String queryString, PropertyRequest propertyRequest) {
		String query = queryString;
		
		if(null != propertyRequest.getPropertyId()) {
			query = query + " and propertyID = "+propertyRequest.getPropertyId();
		}
		if(null != propertyRequest.getPropertyName()) {
			query = query + " and pty_name = '"+propertyRequest.getPropertyName()+"'";
		}
		if(null != propertyRequest.getPropertyTown()) {
			query = query + " and pty_town = '"+propertyRequest.getPropertyTown()+"'";
		}
		if(null != propertyRequest.getPropertyCity()) {
			query = query + " and pty_city = '"+propertyRequest.getPropertyCity()+"'";
		}
		if(null != propertyRequest.getPropertyState()) {
			query = query + " and pty_state = '"+propertyRequest.getPropertyState()+"'";
		}
		if(null != propertyRequest.getPropertyCategory()) {
			query = query + " and pty_category = '"+propertyRequest.getPropertyCategory()+"'";
		}
		if(null != propertyRequest.getPropertyType()) {
			query = query + " and pty_type = '"+propertyRequest.getPropertyType()+"'";
		}
		if(0.0 != propertyRequest.getPropertyPrice()) {
			query = query + " and pty_price = '"+propertyRequest.getPropertyPrice()+"'";
		}
		if(null != propertyRequest.getPropertyStatus()) {
			query = query + " and pty_status = '"+propertyRequest.getPropertyStatus()+"'";
		}
		if(null != propertyRequest.getPropertyOwner()) {
			query = query + " and pty_owner = '"+propertyRequest.getPropertyOwner()+"'";
		}
		if(null != propertyRequest.getPropertyUniqueId()) {
			query = query + " and pty_unique = '"+propertyRequest.getPropertyUniqueId()+"'";
		}
		if(null != propertyRequest.getPropertyArea()) {
			query = query + " and pty_area = "+propertyRequest.getPropertyArea();
		}
		if(null != propertyRequest.getPropertyBed()) {
			query = query + " and pty_bed = "+propertyRequest.getPropertyBed();
		}
		if(null != propertyRequest.getPropertyCountry()) {
			query = query + " and pty_country = '"+propertyRequest.getPropertyCountry()+"'";
		}
		if(null != propertyRequest.getPropertyZipCode()) {
			query = query + " and pty_zipcode = "+propertyRequest.getPropertyZipCode();
		}
		if(null != propertyRequest.getPropertyAvailableDate()) {
			query = query + " and pty_available_date = '"+propertyRequest.getPropertyAvailableDate()+"'";
		}
		if(null != propertyRequest.getPropertyOwnerId()) {
			query = query + " and pty_owner_id = "+propertyRequest.getPropertyOwnerId();
		}
		return query;
	}