import {StyleSheet} from 'react-native';

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#F2F2F2',
    paddingTop: 60,
  },

  titulo: {
    fontSize: 26,
    fontWeight: 'bold',
    marginHorizontal: 20,
    marginBottom: 20,
  },

  lista: {
    paddingHorizontal: 16,
    paddingBottom: 20,
  },

  linha: {
    justifyContent: 'space-between',
    marginBottom: 16,
  },

  card: {
    width: '48%',
    backgroundColor: '#FFFFFF',
    borderRadius: 12,
    padding: 16,
    alignItems: 'center',
    justifyContent: 'center',
    elevation: 3,
  },

  avatar: {
    width: 90,
    height: 90,
    borderRadius: 45,
  },

  nome: {
    fontSize: 16,
    fontWeight: 'bold',
    marginTop: 12,
    textAlign: 'center',
  },

  cidade: {
    fontSize: 14,
    color: '#777777',
    marginTop: 4,
    textAlign: 'center',
  },
});

export default styles;